package com.vstu.employeesystembackend.service;

import com.vstu.employeesystembackend.dto.Task;
import com.vstu.employeesystembackend.exceptions.EmployeeNotFoundException;
import com.vstu.employeesystembackend.exceptions.TaskCannotCreateException;
import com.vstu.employeesystembackend.exceptions.TaskNotFoundException;
import com.vstu.employeesystembackend.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    final private TaskRepository taskRepository;
    @Autowired
    public TaskService(TaskRepository repository){
        this.taskRepository = repository;
    }

    public Task add(Task task) throws TaskCannotCreateException{
        if(task.getName() == null || task.getText() == null || task.getEmployee() == null){
            throw new TaskCannotCreateException("Task must have name, text, employee");
        }

        if(task.getName() == "" || task.getText() == ""){
            throw new TaskCannotCreateException("Invalid task format");
        }

        return taskRepository.save(task);
    }

    public List<Task> getAll(){
        List<Task> tasks = new ArrayList<Task>();
        Iterable<Task> result = taskRepository.findAll();

        result.forEach(tasks::add);
        return tasks;
    }

    public Task update(Long id, Task task) throws TaskNotFoundException{

        if(taskRepository.existsById(id)) {
            task.setTaskId(id);
            return taskRepository.save(task);
        } else {
            throw new TaskNotFoundException(String.format("Task(%d) not found", id));
        }

    }

    public void delete(Long id) throws TaskNotFoundException{

        if(taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
        } else {
            throw new TaskNotFoundException(String.format("Task(%d) not found", id));
        }
    }
}
