package com.taskapp.app.Infrastructure;

import com.taskapp.app.Domain.Model.TaskItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskItemRepository extends JpaRepository<TaskItem, Long> {
}
