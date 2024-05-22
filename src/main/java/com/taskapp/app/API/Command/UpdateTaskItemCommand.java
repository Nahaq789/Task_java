package com.taskapp.app.API.Command;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.taskapp.app.API.CQRS.ICommand;

import lombok.Getter;

@Getter
public class UpdateTaskItemCommand implements ICommand<Boolean> {
    private long TaskItemId;
    private String TaskName;
    private String Content;
    private long _taskStatusId;

    @JsonCreator
    public UpdateTaskItemCommand(
            @JsonProperty("taskItemId") long taskItemId,
            @JsonProperty("taskName") String taskName,
            @JsonProperty("content") String content,
            @JsonProperty("_taskStatusId") long _taskStatusId) {
        TaskItemId = taskItemId;
        TaskName = taskName;
        Content = content;
        this._taskStatusId = _taskStatusId;
    }
}
