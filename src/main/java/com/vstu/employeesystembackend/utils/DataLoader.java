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

        Employee e1 = new Employee();
        e1.setFirstName("Danil");
        e1.setLastName("Svinoukhov");
        e1.setRole(roleRepository.findById(1L).get());

        Employee e2 = new Employee();
        e2.setFirstName("Ilya");
        e2.setLastName("Ignatenko");
        e2.setRole(roleRepository.findById(1L).get());

        Employee e3 = new Employee();
        e3.setFirstName("Andrew");
        e3.setLastName("Abramov");
        e3.setRole(roleRepository.findById(2L).get());

        Employee e4 = new Employee();
        e4.setFirstName("Danil");
        e4.setLastName("Kabirov");
        e4.setRole(roleRepository.findById(2L).get());

        employeeRepository.save(e1);
        employeeRepository.save(e2);
        employeeRepository.save(e3);
        employeeRepository.save(e4);

        taskRepository.save( new Task("Replace todos",
                employeeRepository.findById(1L).get()) );
    }
}
