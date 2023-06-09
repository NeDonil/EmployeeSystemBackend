package com.vstu.employeesystembackend.service;

import com.vstu.employeesystembackend.dto.TaskDTO;
import com.vstu.employeesystembackend.entity.Task;
import com.vstu.employeesystembackend.exceptions.EmployeeNotFoundException;
import com.vstu.employeesystembackend.exceptions.TaskCannotCreateException;
import com.vstu.employeesystembackend.exceptions.TaskNotFoundException;
import com.vstu.employeesystembackend.repository.EmployeeRepository;
import com.vstu.employeesystembackend.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    private TaskRepository taskRepository;
    private EmployeeRepository employeeRepository;
    @Autowired
    public void setTaskRepository(TaskRepository repository){
        this.taskRepository = repository;
    }
    @Autowired
    public void setEmployeeRepository(EmployeeRepository repository){
        this.employeeRepository = repository;
    }


    public Task add(TaskDTO taskDTO) throws TaskCannotCreateException{
        if(taskDTO.getName() == null ||
                taskDTO.getDescription() == null ||
                taskDTO.getEmployeeId() == null ||
                taskDTO.getStartline() == null ||
                taskDTO.getDeadline() == null){
            throw new TaskCannotCreateException("Task must have name, description, employee, startline, deadline");
        }

        if(taskDTO.getName() == "" || taskDTO.getDescription() == ""){
            throw new TaskCannotCreateException("Invalid task format");
        }

        if(taskDTO.getStartline().isAfter(taskDTO.getDeadline())) {
            throw new TaskCannotCreateException("The startline must be before the deadline");
        }

        Task task = new Task();
        task.setName(taskDTO.getName());
        task.setDescription(taskDTO.getDescription());
        task.setDeadline(taskDTO.getDeadline());
        task.setStartline(taskDTO.getStartline());

        var employeeCandidate = employeeRepository.findById(taskDTO.getEmployeeId());
        if(employeeCandidate.isPresent()){
            task.setEmployee(employeeCandidate.get());
        } else {
            throw new TaskCannotCreateException("Employee not found");
        }

        return taskRepository.save(task);
    }

    public void addTaskToEmployee(Long taskId, Long employeeId) throws EmployeeNotFoundException, TaskNotFoundException {

        var taskCandid = taskRepository.findById(taskId);
        if(!taskCandid.isPresent()){
            throw new TaskNotFoundException("Task not found");
        }

        var employeeCandid = employeeRepository.findById(employeeId);
        if(!employeeCandid.isPresent()){
            throw new EmployeeNotFoundException("Employee not found");
        }

        var task = taskCandid.get();
        employeeCandid.get().getTasks().add(task);
        employeeRepository.save(employeeCandid.get());
    }

    public List<Task> getAll(){
        ArrayList<Task> result = new ArrayList<Task>();
        Iterable<Task> tasks = taskRepository.findAll();
        tasks.forEach(result::add);
        return result;
    }

    public List<Task> getEmployeeTasks(Long employeeId){
        ArrayList<Task> result = new ArrayList<>();
        Iterable<Task> tasks = taskRepository.findByEmployeeEmployeeId(employeeId);
        tasks.forEach(result::add);
        return result;
    }

    public Task update(Long id, TaskDTO taskDTO) throws TaskNotFoundException{

        if(taskDTO.getName() == null ||
                taskDTO.getDescription() == null ||
                taskDTO.getEmployeeId() == null ||
                taskDTO.getStartline() == null ||
                taskDTO.getDeadline() == null){
            throw new TaskCannotCreateException("Task must have name, description, employee, startline, deadline");
        }

        if(taskDTO.getName() == "" || taskDTO.getDescription() == ""){
            throw new TaskCannotCreateException("Invalid task format");
        }

        if(taskDTO.getStartline().isAfter(taskDTO.getDeadline())) {
            throw new TaskCannotCreateException("The startline must be before the deadline");
        }

        Task task = new Task();
        task.setName(taskDTO.getName());
        task.setDescription(taskDTO.getDescription());
        task.setDeadline(taskDTO.getDeadline());
        task.setStartline(taskDTO.getStartline());

        var employeeCandidate = employeeRepository.findById(taskDTO.getEmployeeId());
        if(employeeCandidate.isPresent()){
            task.setEmployee(employeeCandidate.get());
        } else {
            throw new TaskCannotCreateException("Employee not found");
        }

        return taskRepository.save(task);
    }

    public void delete(Long id) throws TaskNotFoundException{

        if(taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
        } else {
            throw new TaskNotFoundException(String.format("Task(%d) not found", id));
        }
    }
}
