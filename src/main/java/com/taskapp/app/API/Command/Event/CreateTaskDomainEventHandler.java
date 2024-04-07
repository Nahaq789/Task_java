package com.taskapp.app.API.Command.Event;

import com.taskapp.app.Domain.Model.Event.CreateTaskDomainEvent;
import com.taskapp.app.Domain.Model.TaskEntity;
import com.taskapp.app.Infrastructure.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

public class CreateTaskDomainEventHandler implements IDomainEventHandler<CreateTaskDomainEvent> {
    @Autowired
    private final TaskRepository _taskRepository;
    public CreateTaskDomainEventHandler(TaskRepository taskRepository) {
        this._taskRepository = taskRepository;
    }
    @Override
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMPLETION)
    public void Handle(CreateTaskDomainEvent event) {
        TaskEntity task = new TaskEntity(event.get_taskId());
        _taskRepository.save(task);
    }
}
