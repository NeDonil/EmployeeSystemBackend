package com.vstu.employeesystembackend.utils;

import com.vstu.employeesystembackend.entity.*;
import com.vstu.employeesystembackend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private EmployeeRepository employeeRepository;
    private RoleRepository roleRepository;

    private TaskRepository taskRepository;
    private AuthorityRepository authorityRepository;

    private DocumentRepository documentRepository;


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

    @Autowired
    public void setAuthorityRepository(AuthorityRepository repository) {
        this.authorityRepository = repository;
    }

    @Autowired
    public void setDocumentRepository(DocumentRepository repository) {
        this.documentRepository = repository;
    }

    public void run(ApplicationArguments args) {
        var cu = authorityRepository.save(new Authority("CREATE_USER"));
        var ru = authorityRepository.save(new Authority("READ_USER"));
        var uu = authorityRepository.save(new Authority("UPDATE_USER"));
        var du = authorityRepository.save(new Authority("DELETE_USER"));

        var adminRole = roleRepository.save(new Role("Admin"));
        adminRole.getAuthorities().add(cu);
        adminRole.getAuthorities().add(ru);
        adminRole.getAuthorities().add(uu);
        adminRole.getAuthorities().add(du);
        roleRepository.save(adminRole);

        var managerRole = roleRepository.save(new Role("Manager"));
        managerRole.getAuthorities().add(cu);
        managerRole.getAuthorities().add(ru);
        managerRole.getAuthorities().add(du);
        roleRepository.save(managerRole);

        var employeeRole = roleRepository.save(new Role("Employee"));
        employeeRole.getAuthorities().add(ru);
        roleRepository.save(employeeRole);

        var passport = documentRepository.save(new Document("Passport", "1234522f"));
        documentRepository.save(passport);

        Employee e1 = new Employee();
        e1.setFirstname("Danil");
        e1.setLastname("Svinoukhov");
        e1.setUsername("NeDonil");
        e1.setDocument(passport);
        e1.getRoles().add(adminRole);

        Employee e2 = new Employee();
        e2.setFirstname("Ilya");
        e2.setLastname("Ignatenko");
        e2.setUsername("igntnk");
        e2.getRoles().add(adminRole);

        Employee e3 = new Employee();
        e3.setFirstname("Andrew");
        e3.setLastname("Abramov");
        e3.setUsername("Xblunt");
        e3.getRoles().add(managerRole);

        Employee e4 = new Employee();
        e4.setFirstname("Danil");
        e4.setLastname("Kabirov");
        e4.setLastname("Kabup");
        e4.getRoles().add(employeeRole);

        employeeRepository.save(e1);
        employeeRepository.save(e2);
        employeeRepository.save(e3);
        employeeRepository.save(e4);

        taskRepository.save( new Task("Replace todos", e1) );
        taskRepository.save( new Task("Create todos", e2) );
        taskRepository.save( new Task("Find todos", e2) );
        taskRepository.save( new Task("Delete todos", e3) );
        taskRepository.save( new Task("Fuck todos", e4) );
        taskRepository.save( new Task("Love todos", e1) );
    }
}
