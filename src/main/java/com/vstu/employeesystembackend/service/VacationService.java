package com.vstu.employeesystembackend.service;

import com.vstu.employeesystembackend.dto.VacationDTO;
import com.vstu.employeesystembackend.entity.Role;
import com.vstu.employeesystembackend.entity.Vacation;
import com.vstu.employeesystembackend.exceptions.TaskCannotCreateException;
import com.vstu.employeesystembackend.exceptions.VacationCannotCreateException;
import com.vstu.employeesystembackend.repository.EmployeeRepository;
import com.vstu.employeesystembackend.repository.RoleRepository;
import com.vstu.employeesystembackend.repository.VacationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VacationService {
    private VacationRepository vacationRepository;
    private EmployeeRepository employeeRepository;
    @Autowired
    public void setVacationRepository(VacationRepository repository){
        this.vacationRepository = repository;
    }

    @Autowired
    public void setEmployeeRepository(EmployeeRepository repository){
        this.employeeRepository = repository;
    }

    public Vacation add(VacationDTO vacationDTO) throws VacationCannotCreateException{

        if(vacationDTO.getEmployeeId() == null || vacationDTO.getBeginDate() == null || vacationDTO.getEndDate() == null){
            throw new VacationCannotCreateException("Vacation must have employeeId, Begin date, End date");
        }

        if(vacationDTO.getBeginDate().isAfter(vacationDTO.getEndDate())) {
            throw new VacationCannotCreateException("The Begin date must be before the End date");
        }

        Vacation vacation = new Vacation();
        var employeeCandid = employeeRepository.findById(vacationDTO.getEmployeeId());

        if(employeeCandid.isPresent()){
            vacation.setEmployee(employeeCandid.get());
        } else {
            throw new VacationCannotCreateException("Employee is not exist");
        }

        vacation.setBeginDate(vacationDTO.getBeginDate());
        vacation.setEndDate(vacationDTO.getEndDate());

        return vacationRepository.save(vacation);
    }


}
