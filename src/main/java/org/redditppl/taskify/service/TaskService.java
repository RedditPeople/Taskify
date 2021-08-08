package org.redditppl.taskify.service;


import org.redditppl.taskify.exceptions.TaskNotFoundException;
import org.redditppl.taskify.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();
    Task getTaskById(long id);
    Task saveTask(Task task);
    Task getTaskByName(String name) throws TaskNotFoundException;
}
