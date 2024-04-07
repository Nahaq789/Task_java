package com.taskapp.app.Infrastructure;

import jakarta.persistence.Entity;
import org.springframework.stereotype.Repository;

@Repository
public interface ITaskRepository {
    void save(Entity entity);
}
