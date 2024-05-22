package com.taskapp.app.API.Command;

import org.springframework.stereotype.Service;

import com.taskapp.app.API.CQRS.ICommandHandler;
import com.taskapp.app.Domain.Model.TaskItem;
import com.taskapp.app.Infrastructure.TaskItemRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UpdateTaskItemCommandHandler implements ICommandHandler<Boolean, UpdateTaskItemCommand> {
    private TaskItemRepository _repository;

    @Transactional
    public Boolean Handle(UpdateTaskItemCommand command) {
        TaskItem task = new TaskItem(
                command.getTaskItemId(),
                command.getTaskName(),
                command.getContent());

        _repository.save(task);
        return true;
    }
}
