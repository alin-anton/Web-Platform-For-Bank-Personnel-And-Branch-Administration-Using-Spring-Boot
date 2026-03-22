package com.antonalin.pibdspring.service.impl;

import com.antonalin.pibdspring.entity.Employees;
import com.antonalin.pibdspring.repository.EmployeesRepository;
import com.antonalin.pibdspring.service.EmployeesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesServiceImpl implements EmployeesService {
    private EmployeesRepository EmployeesRepository;

    public EmployeesServiceImpl(EmployeesRepository employeesRepository) {
        super();
        this.EmployeesRepository = employeesRepository;
    }

    @Override
    public List<Employees> getAllEmployees(){
        return EmployeesRepository.findAll();
    }

    @Override
    public Employees saveEmployee(Employees angajat){
        return EmployeesRepository.save(angajat);
    }

    @Override
    public Employees getEmployeeByID(Long id){
        return EmployeesRepository.findById(id).get();
    }

    @Override
    public Employees updateEmployee(Employees angajat){
        return EmployeesRepository.save(angajat);
    }

    @Override
    public void deleteEmployeeByID(Long id){
        EmployeesRepository.deleteById(id);
    }
}
