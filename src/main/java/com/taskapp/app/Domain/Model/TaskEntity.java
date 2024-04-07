package com.taskapp.app.Domain.Model;

import com.taskapp.app.Domain.Model.Event.IDomainEvent;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Task")
public class TaskEntity {
    @Id
    @Getter
    private final UUID TaskId;

    @Column
    @Getter
    @Setter
    private long _taskStatusId;

    @Getter
    private TaskStatus _taskStatus;

    @Transient
    private final List<IDomainEvent> _taskDomainEvent = new ArrayList<>();

    public TaskEntity(UUID taskId) {
        this.TaskId = taskId;
        set_taskStatusId(TaskStatus.Create.getTaskStatusId());
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
