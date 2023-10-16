package com.senac.senacswagger;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TaskService {

    private List<Task> tasks = new ArrayList<>();

    public List<Task> getAllTasks() {
        return tasks;
    }

    public Task getTaskById(Long taskId) {
        return tasks.stream()
                .filter(task -> task.getId().equals(taskId))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Tarefa não encontrada com o ID: " + taskId));
    }

    public Task addTask(Task task) {
        long newId = tasks.size() + 1;
        task.setId(newId);
        tasks.add(task);
        return task;
    }

    public Task updateTask(Long taskId, Task task) {
        Task existingTask = getTaskById(taskId);
        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        existingTask.setDueDate(task.getDueDate());
        return existingTask;
    }

    public void deleteTask(Long taskId) {
        tasks.removeIf(task -> task.getId().equals(taskId));
    }
}

