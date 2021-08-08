package org.redditppl.taskify.service;

import lombok.RequiredArgsConstructor;
import org.redditppl.taskify.exceptions.TaskNotFoundException;
import org.redditppl.taskify.model.Task;
import org.redditppl.taskify.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(long id) {
        return taskRepository.getById(id);
    }

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task getTaskByName(String name) throws TaskNotFoundException {
        Optional<Task> matchingObject = taskRepository.findAll().stream()
                .filter( t -> t.getName().equals(name)).findFirst();
        if( matchingObject.isPresent()){
            return matchingObject.get();
        }else{
            throw new TaskNotFoundException("Task not found with this name: " + name);
        }
    }
}
