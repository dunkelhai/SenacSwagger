package com.senac.senacswagger;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    @ApiOperation(value = "Lista todas as tarefas")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{taskId}")
    @ApiOperation(value = "Obtém uma tarefa por ID")
    public Task getTaskById(@PathVariable Long taskId) {
        return taskService.getTaskById(taskId);
    }

    @PostMapping("/")
    @ApiOperation(value = "Adiciona uma nova tarefa")
    public Task addTask(@RequestBody Task task) {
        return taskService.addTask(task);
    }

    @PutMapping("/{taskId}")
    @ApiOperation(value = "Atualiza uma tarefa existente")
    public Task updateTask(@PathVariable Long taskId, @RequestBody Task task) {
        return taskService.updateTask(taskId, task);
    }

    @DeleteMapping("/{taskId}")
    @ApiOperation(value = "Remove uma tarefa por ID")
    public void deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
    }
}

