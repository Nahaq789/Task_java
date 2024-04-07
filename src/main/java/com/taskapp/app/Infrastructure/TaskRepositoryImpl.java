package com.taskapp.app.Infrastructure;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class TaskRepositoryImpl implements ITaskRepository {
    @PersistenceContext
    private EntityManager _entityManager;

    @Override
    public void save(Entity entity) {

    }
}
