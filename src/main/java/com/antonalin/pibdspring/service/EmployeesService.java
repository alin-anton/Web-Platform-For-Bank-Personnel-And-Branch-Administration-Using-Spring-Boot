package com.antonalin.pibdspring.service;

import com.antonalin.pibdspring.entity.Employees;

import java.util.List;

public interface EmployeesService {
    List<Employees> getAllEmployees();

    Employees saveEmployee(Employees angajat);

    Employees getEmployeeByID(Long id);

    Employees updateEmployee(Employees angajat);

    void deleteEmployeeByID(Long id);
}
