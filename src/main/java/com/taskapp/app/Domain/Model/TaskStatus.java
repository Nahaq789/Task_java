package com.taskapp.app.Domain.Model;

import lombok.Data;

@Data
public class TaskStatus {
    private long TaskStatusId;
    private String Status;

    public static TaskStatus Create = new TaskStatus(1, "Create");
    public static TaskStatus ToDo = new TaskStatus(2, "ToDo");
    public static TaskStatus Doing = new TaskStatus(3, "Doing");
    public static TaskStatus Commit = new TaskStatus(4, "Commit");
    public static TaskStatus Done = new TaskStatus(5, "Done");

    public TaskStatus(long taskStatusId, String status) {
        this.TaskStatusId = taskStatusId;
        this.Status = status;
    }

    public TaskStatus() {
    }

}
