package com.taskapp.app.API.Command;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.taskapp.app.API.CQRS.IQueryHandler;
import com.taskapp.app.API.Dto.TaskItemDto;
import com.taskapp.app.Domain.Model.TaskItem;
import com.taskapp.app.Infrastructure.TaskItemRepository;

import jakarta.transaction.Transactional;

@Service
public class GetAllTaskItemQueryHandler implements IQueryHandler<List<TaskItemDto>, GetAllTaskItemQuery> {
    private TaskItemRepository _repository;
    private ModelMapper _modelMapper;

    public GetAllTaskItemQueryHandler(TaskItemRepository repository, ModelMapper modelmapper) {
        this._repository = repository;
        this._modelMapper = modelmapper;
    }

    @Transactional
    public List<TaskItemDto> Handle(GetAllTaskItemQuery query) {
        List<TaskItem> result = _repository.findAll();
        List<TaskItemDto> taskDto = new ArrayList<TaskItemDto>();

        for (TaskItem item : result) {
            TaskItemDto dto = _modelMapper.map(item, TaskItemDto.class);
            taskDto.add(dto);
        }

        return taskDto;
    }

}
