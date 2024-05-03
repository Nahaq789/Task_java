package com.taskapp.app.Domain.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    public TaskItem() { }
}
