package com.taskapp.app.Domain.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;

import com.taskapp.app.Domain.Model.Event.IDomainEvent;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;

@Entity
@Table(name = "Task")
public class TaskEntity {
    @Id
    @Column(name = "task_id")
    private UUID TaskId;

    @Column(name = "task_status_id")
    private long _taskStatusId;

    @Getter
    @Transient
    private TaskStatus _taskStatus;

    @Transient
    private final List<IDomainEvent> _taskDomainEvent = new ArrayList<>();

    public TaskEntity(UUID taskId, long taskStatusId) {
        this.TaskId = taskId;
        this._taskStatusId = taskStatusId;
    }

    public TaskEntity() {
    }

    public void publishEvent(IDomainEvent event) {
        _taskDomainEvent.add(event);
    }

    @DomainEvents
    public List<IDomainEvent> get_taskDomainEvent() {
        return _taskDomainEvent;
    }

    @AfterDomainEventPublication
    public void clearDomainEvent() {
        _taskDomainEvent.clear();
    }

}
