package com.taskapp.app.Domain.Model.Event;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateTaskDomainEvent implements IDomainEvent {
    private final UUID _taskId;
    private final long _taskItemId;
    // private final long _taskStatusId;
}
