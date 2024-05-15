package com.taskapp.app.API.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TaskItemDto {
    private long TaskItemId;
    private String TaskName;
    private String Content;
}
