package com.antonalin.pibdspring.repository;

import com.antonalin.pibdspring.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository extends JpaRepository<Employees,Long> {
}
