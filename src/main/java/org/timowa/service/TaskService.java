package org.timowa.service;

import lombok.RequiredArgsConstructor;
import org.timowa.database.entity.Task;
import org.timowa.database.repository.TaskRepository;
import java.util.Optional;

@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public void addTask(Task task) {
        taskRepository.save(task);
    }

    public boolean deleteTaskById(Long id) {
        var maybeTask = taskRepository.findById(id);
        maybeTask.ifPresent(user -> taskRepository.delete(id));
        return maybeTask.isPresent();
    }

    public void updateTask(Task task) {
        taskRepository.update(task);
    }

    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    public Optional<Task> findAllByCompleted(Boolean completed) {
        return Optional.ofNullable(taskRepository.findAllByCompleted(completed));
    }
}
