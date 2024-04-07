package com.taskapp.app.Domain.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import javax.naming.Name;

@Data
@Entity
public class TaskStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final long TaskStatusId;
    private final String Status;

    public static TaskStatus Create = new TaskStatus(1, new Object(){}.getClass().getEnclosingMethod().getName());
    public static TaskStatus ToDO = new TaskStatus(2, new Object(){}.getClass().getEnclosingMethod().getName());
    public static TaskStatus Doing = new TaskStatus(3, new Object(){}.getClass().getEnclosingMethod().getName());
    public static TaskStatus Commit = new TaskStatus(4, new Object(){}.getClass().getEnclosingMethod().getName());
    public static TaskStatus Done = new TaskStatus(5, new Object(){}.getClass().getEnclosingMethod().getName());
    public TaskStatus(long taskStatusId, String status) {
        this.TaskStatusId = taskStatusId;
        this.Status = status;
    }

    public long getTaskStatusId() {
        return TaskStatusId;
    }

    public String getStatus() {
        return Status;
    }
}
