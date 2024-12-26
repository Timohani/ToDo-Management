package org.timowa.database.repository;

import org.timowa.database.entity.Task;

import javax.persistence.EntityManager;
import java.util.Optional;

public class TaskRepository extends BaseRepository<Long, Task> {
    private EntityManager entityManager;

    public TaskRepository(EntityManager entityManager) {
        super(Task.class, entityManager);
    }

    public Task findAllByCompleted(Boolean completed) {
        return entityManager.find(Task.class, Task.builder().completed(true).build());
    }
}
