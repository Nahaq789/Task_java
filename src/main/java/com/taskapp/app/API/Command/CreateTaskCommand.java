package com.taskapp.app.API.Command;

import com.taskapp.app.API.CQRS.ICommand;
import lombok.Getter;

import java.util.UUID;

@Getter
public class CreateTaskCommand implements ICommand<Long> {
    private final long TaskItemId;
    private final String TaskName;
    private final String Content;
    private final long _taskStatusId;
    public CreateTaskCommand(long taskItemId, String taskName, String content, long _taskStatusId) {
        TaskItemId = taskItemId;
        TaskName = taskName;
        Content = content;
        this._taskStatusId = _taskStatusId;
    }
}
