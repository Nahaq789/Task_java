package com.taskapp.app.Domain.Model.Event;

import com.taskapp.app.API.Command.CreateTaskCommand;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class CreateTaskDomainEvent implements IDomainEvent {
    private final UUID _taskId;
    private final long _taskItemId;
    private final long _taskStatusId;
}
