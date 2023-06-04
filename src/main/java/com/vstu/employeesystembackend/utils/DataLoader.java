package com.vstu.employeesystembackend.utils;

import com.vstu.employeesystembackend.entity.*;
import com.vstu.employeesystembackend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.time.LocalDate;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    JdbcTemplate jdbcTemplate;

    private EmployeeRepository employeeRepository;
    private RoleRepository roleRepository;
    private TaskRepository taskRepository;
    private AuthorityRepository authorityRepository;
    private DocumentRepository documentRepository;
    private VacationRepository vacationRepository;
    private PaymentRepository paymentRepository;
    private RankRepository rankRepository;

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

    @Autowired
    public void setVacationRepository(VacationRepository repository) {
        this.vacationRepository = repository;
    }

    @Autowired
    public void setPaymentRepository(PaymentRepository repository) {
        this.paymentRepository = repository;
    }

    @Autowired
    public void setRankRepository(RankRepository repository) {
        this.rankRepository = repository;
    }

    public void run(ApplicationArguments args) {
        var cu = authorityRepository.save(new Authority("CREATE_USER"));
        var ru = authorityRepository.save(new Authority("READ_USER"));
        var uu = authorityRepository.save(new Authority("UPDATE_USER"));
        var du = authorityRepository.save(new Authority("DELETE_USER"));

        authorityRepository.save(cu);
        authorityRepository.save(ru);
        authorityRepository.save(uu);
        authorityRepository.save(du);

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

        var passport = documentRepository.save(new Document("Passport", "2018122374"));
        documentRepository.save(passport);

        var snils = documentRepository.save(new Document("SNILS", "82653719752"));
        documentRepository.save(snils);

        var medicalBook = documentRepository.save(new Document("Medical book", "73855262"));
        documentRepository.save(medicalBook);

        Rank admin = new Rank();
        admin.setName("Admin");

        Rank director = new Rank();
        director.setName("Director");

        Rank assistant = new Rank();
        assistant.setName("Assistant");

        Rank manager = new Rank();
        manager.setName("Manager");

        Rank worker = new Rank();
        worker.setName("Worker");

        rankRepository.save(admin);
        rankRepository.save(director);
        rankRepository.save(assistant);
        rankRepository.save(manager);
        rankRepository.save(worker);

        rankRepository.save(admin);
        rankRepository.save(director);
        rankRepository.save(assistant);
        rankRepository.save(manager);
        rankRepository.save(worker);

        Employee e1 = new Employee();
        e1.setFirstname("Danil");
        e1.setLastname("Svinoukhov");
        e1.setUsername("Danil");
        e1.setPassword("234");
        e1.setHireDate(LocalDate.now());
        e1.setDocument(passport);
        e1.getRoles().add(adminRole);
        e1.setRank(worker);
        e1.setDocument(passport);

        Employee e2 = new Employee();
        e2.setFirstname("Ilya");
        e2.setLastname("Ignatenko");
        e2.setUsername("Ilya");
        e2.setPassword("123");
        e2.setHireDate(LocalDate.now());
        e1.setDocument(passport);
        e2.getRoles().add(adminRole);
        e2.setRank(admin);

        Employee e3 = new Employee();
        e3.setFirstname("Andrew");
        e3.setLastname("Abramov");
        e3.setUsername("Xblunt");
        e3.setPassword("567");
        e3.setHireDate(LocalDate.now());
        e3.setDocument(passport);
        e3.getRoles().add(managerRole);
        e3.setRank(worker);

        Employee e4 = new Employee();
        e4.setFirstname("Danil");
        e4.setLastname("Kabirov");
        e4.setUsername("Kabup");
        e4.setPassword("345");
        e4.setHireDate(LocalDate.now());
        e4.setDocument(passport);
        e4.getRoles().add(employeeRole);
        e4.setRank(admin);
        e4.setDocument(snils);

        Employee e5 = new Employee();
        e5.setFirstname("Kirill");
        e5.setLastname("Bezuglyi");
        e5.setUsername("Kirill");
        e5.setPassword("678");
        e5.setDocument(passport);
        e5.setHireDate(LocalDate.now());
        e5.getRoles().add(employeeRole);
        e5.setRank(admin);

        Vacation v1 = new Vacation();
        v1.setBeginDate(LocalDate.of(2021, 12, 22));
        v1.setEndDate(LocalDate.of(2022, 01, 22));

        Vacation v2 = new Vacation();
        v2.setBeginDate(LocalDate.of(2023, 5, 12));
        v2.setEndDate(LocalDate.of(2023, 5, 30));

        v1.setEmployee(e1);
        v2.setEmployee(e2);

        Payment p1 = new Payment();
        p1.setName("Danil Salary");
        p1.setPaidAmount(30000);

        Payment p2 = new Payment();
        p1.setName("Ilya Salary");
        p1.setPaidAmount(40000);

        Payment p3 = new Payment();
        p1.setName("Andrey Salary");
        p1.setPaidAmount(280000);

        Payment p4 = new Payment();
        p1.setName("Zuzev Salary");
        p1.setPaidAmount(500000);

        paymentRepository.save(p1);
        paymentRepository.save(p2);
        paymentRepository.save(p3);
        paymentRepository.save(p4);

        employeeRepository.save(e1);
        employeeRepository.save(e2);
        employeeRepository.save(e3);
        employeeRepository.save(e4);
        employeeRepository.save(e5);

        vacationRepository.save(v1);
        vacationRepository.save(v2);

        taskRepository.save( new Task("Replace todos", e1) );
        taskRepository.save( new Task("Create todos", e2) );
        taskRepository.save( new Task("Find todos", e2) );
        taskRepository.save( new Task("Delete todos", e3) );
        taskRepository.save( new Task("Fuck todos", e4) );
        taskRepository.save( new Task("Love todos", e1) );

        vacationRepository.save(v1);
        vacationRepository.save(v2);

        try {
            executeScript();
        } catch(SQLException e){

        }
    }

    void executeScript() throws SQLException {
        String scriptPath = "init-database.sql";
        ClassPathResource resource = new ClassPathResource(scriptPath);

        ScriptUtils.executeSqlScript(jdbcTemplate.getDataSource().getConnection(), resource);
    }
}
