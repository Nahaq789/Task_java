package com.taskapp.app.API.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskItemDto {
    private long TaskItemId;
    private String TaskName;
    private String Content;
}
