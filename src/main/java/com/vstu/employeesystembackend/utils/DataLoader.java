package com.vstu.employeesystembackend.utils;

import com.vstu.employeesystembackend.dto.Employee;
import com.vstu.employeesystembackend.dto.Role;
import com.vstu.employeesystembackend.dto.Task;
import com.vstu.employeesystembackend.repository.EmployeeRepository;
import com.vstu.employeesystembackend.repository.RoleRepository;
import com.vstu.employeesystembackend.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private EmployeeRepository employeeRepository;
    private RoleRepository roleRepository;

    private TaskRepository taskRepository;

    @Autowired
    public void setEmployeeRepository(EmployeeRepository repository) {
        this.employeeRepository = repository;
    }

    @Autowired
    public void setRoleRepository(RoleRepository repository) {
        this.roleRepository = repository;
    }

    @Autowired
    public void setTaskRepository(TaskRepository repository) {
        this.taskRepository = repository;
    }

    public void run(ApplicationArguments args) {
        roleRepository.save(new Role("Admin"));
        roleRepository.save(new Role("Manager"));
        roleRepository.save(new Role("Employee"));

        employeeRepository.save(new Employee("Danil", "Svinoukhov"));
        employeeRepository.save(new Employee("Ilya", "Ignatenko"));
        employeeRepository.save(new Employee("Andrew", "Abramov"));
        employeeRepository.save(new Employee("Danil", "Kabirov"));

        taskRepository.save( new Task("Replace todos",
                employeeRepository.findById(1L).get()) );
    }
}
