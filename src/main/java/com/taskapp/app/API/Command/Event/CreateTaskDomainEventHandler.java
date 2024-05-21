package com.taskapp.app.API.Command.Event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.taskapp.app.Domain.Model.TaskEntity;
import com.taskapp.app.Domain.Model.TaskStatus;
import com.taskapp.app.Domain.Model.Event.CreateTaskDomainEvent;
import com.taskapp.app.Infrastructure.TaskRepository;

import lombok.var;

@Service
public class CreateTaskDomainEventHandler implements IDomainEventHandler<CreateTaskDomainEvent> {
    private TaskRepository _taskRepository;

    public CreateTaskDomainEventHandler(TaskRepository taskRepository) {
        this._taskRepository = taskRepository;
    }

    @Override
    @EventListener
    public void Handle(CreateTaskDomainEvent event) {
        var statusId = TaskStatus.Create.getTaskStatusId();
        TaskEntity task = new TaskEntity(event.get_taskId(), statusId);
        _taskRepository.save(task);
    }
}
