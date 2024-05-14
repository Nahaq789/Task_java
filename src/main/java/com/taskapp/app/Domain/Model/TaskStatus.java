package com.taskapp.app.Domain.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import javax.naming.Name;

@Data
public class TaskStatus {
    private long TaskStatusId;
    private String Status;

    public static TaskStatus Create = new TaskStatus(1, "Create");
    public static TaskStatus ToDo = new TaskStatus(2, new Object(){}.getClass().getEnclosingMethod().getName());
    public static TaskStatus Doing = new TaskStatus(3, new Object(){}.getClass().getEnclosingMethod().getName());
    public static TaskStatus Commit = new TaskStatus(4, new Object(){}.getClass().getEnclosingMethod().getName());
    public static TaskStatus Done = new TaskStatus(5, new Object(){}.getClass().getEnclosingMethod().getName());

    public TaskStatus(long taskStatusId, String status) {
        this.TaskStatusId = taskStatusId;
        this.Status = status;
    }

    public TaskStatus() { }

}
