package com.taskapp.app.API.Command.Event;

import com.taskapp.app.Domain.Model.Event.CreateTaskDomainEvent;
import com.taskapp.app.Domain.Model.TaskEntity;
import com.taskapp.app.Infrastructure.TaskRepository;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class CreateTaskDomainEventHandler implements IDomainEventHandler<CreateTaskDomainEvent> {
    private TaskRepository _taskRepository;

    public CreateTaskDomainEventHandler(TaskRepository taskRepository) {
        this._taskRepository = taskRepository;
    }

    @Override
    @EventListener
    public void Handle(CreateTaskDomainEvent event) {
        TaskEntity task = new TaskEntity(event.get_taskId(), event.get_taskStatusId());
        System.err.println(task);
        _taskRepository.save(task);
    }
}
