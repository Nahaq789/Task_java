package com.taskapp.app.API.Command;

import com.taskapp.app.API.CQRS.ICommandHandler;
import com.taskapp.app.Domain.Model.TaskItem;
import com.taskapp.app.Infrastructure.TaskItemRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateTaskCommandHandler implements ICommandHandler<Long, CreateTaskCommand> {
    @Autowired
    private TaskItemRepository _repository;

    @Transactional
    public Long Handle(CreateTaskCommand command) {
        TaskItem task = new TaskItem(
                command.getTaskName(),
                command.getContent());
        TaskItem result = _repository.save(task);
        return result.getTaskItemId();
    }
}