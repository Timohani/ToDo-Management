package org.timowa.mapper;

import lombok.RequiredArgsConstructor;
import org.timowa.database.entity.Task;
import org.timowa.dto.TaskDto;

@RequiredArgsConstructor
public class TaskMapper implements Mapper<Task, TaskDto> {

    @Override
    public TaskDto mapFrom(Task task) {
        return new TaskDto(task.getId(), task.getDescription(), task.getCompleted());
    }
}
