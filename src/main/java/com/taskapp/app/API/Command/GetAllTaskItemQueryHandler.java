package com.taskapp.app.API.Command;

import java.util.List;

import org.springframework.stereotype.Service;

import com.taskapp.app.API.CQRS.IQueryHandler;
import com.taskapp.app.API.Dto.TaskItemDto;
import com.taskapp.app.Domain.Model.TaskItem;
import com.taskapp.app.Infrastructure.TaskItemRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GetAllTaskItemQueryHandler implements IQueryHandler<List<TaskItemDto>, GetAllTaskItemQuery> {
    private TaskItemRepository _repository;

    @Transactional
    public List<TaskItemDto> Handle(GetAllTaskItemQuery query) {
        List<TaskItem> result = _repository.findAll();
        return result;

    }

}
