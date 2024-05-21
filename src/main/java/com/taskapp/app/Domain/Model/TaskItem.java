package com.taskapp.app.Domain.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Table(name = "TaskItem")
@Entity
@Getter
public class TaskItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long TaskItemId;
    @Column(name = "TaskName")
    private String TaskName;
    @Column(name = "Content")
    private String Content;

    public TaskItem(long taskItemId, String taskName, String content) {
        this.TaskItemId = taskItemId;
        this.TaskName = taskName;
        this.Content = content;
    }

    public TaskItem(String taskName, String content) {
        this.TaskName = taskName;
        this.Content = content;
    }

    public TaskItem() {
    }
}
