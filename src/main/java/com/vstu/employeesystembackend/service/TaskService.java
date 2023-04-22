package com.vstu.employeesystembackend.service;

import com.vstu.employeesystembackend.dto.Task;
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

    public Task add(Task role){
        return taskRepository.save(role);
    }

    public List<Task> getAll(){
        List<Task> tasks = new ArrayList<Task>();
        Iterable<Task> result = taskRepository.findAll();

        result.forEach(tasks::add);
        return tasks;
    }

    public Task update(Long id, Task task){
        if(taskRepository.existsById(id)) {
            task.setTaskId(id);
            return taskRepository.save(task);
        };

        //TODO throw exception
        return new Task();
    }

    public void delete(Long id){
        taskRepository.deleteById(id);
    }
}
