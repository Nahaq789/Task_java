package com.taskapp.app.Infrastructure;

import com.taskapp.app.Domain.Model.TaskItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskItemRepository extends JpaRepository<TaskItem, Long> {
}
