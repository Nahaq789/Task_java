package com.taskapp.app.API.Command;

import java.util.List;

import com.taskapp.app.API.CQRS.IQuery;
import com.taskapp.app.API.Dto.TaskItemDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetAllTaskItemQuery implements IQuery<List<TaskItemDto>> {
    private long TaskItemId;
    private String TaskName;
    private String Content;
}
