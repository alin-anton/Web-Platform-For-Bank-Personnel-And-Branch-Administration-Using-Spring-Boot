package com.antonalin.pibdspring.controller;

import com.antonalin.pibdspring.entity.Bank;
import com.antonalin.pibdspring.entity.Employees;
import com.antonalin.pibdspring.repository.BankRepository;
import com.antonalin.pibdspring.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmployeesController {
    private EmployeesService employeesService;

    @Autowired
    private BankRepository bankRepository;

    public EmployeesController(EmployeesService employeesService) {
        super();
        this.employeesService = employeesService;
    }

    @GetMapping("/employees")
    public String listEmployees(Model model){
        model.addAttribute("employees",employeesService.getAllEmployees());
        return "employees";
    }

    @GetMapping("/employees/new")
    public String createEmployeeForm(Model model){
        List<Bank> allBanks = bankRepository.findAll();

        Employees Employees = new Employees();
        model.addAttribute("employees",Employees);
        model.addAttribute("allbanks",allBanks);

        return "create_employee";
    }

    @PostMapping("/employees")
    public String saveEmployee(@ModelAttribute("employees") Employees employee){
        employeesService.saveEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/employees/edit/{idEmployee}")
    public String editEmployee(@PathVariable Long idEmployee, Model model){
        List<Bank> allBanks = bankRepository.findAll();

        model.addAttribute("employees",employeesService.getEmployeeByID(idEmployee));
        model.addAttribute("allbanks",allBanks);

        return "edit_employee";
    }

    @PostMapping("/employees/{idEmployee}")
    public String updateEmployee(@PathVariable Long idEmployee, @ModelAttribute("employees") Employees employee,Model model){
        Employees existentEmployee = employeesService.getEmployeeByID(idEmployee);

        existentEmployee.setIdEmployee(idEmployee);
        existentEmployee.setFnameEmployee(employee.getFnameEmployee());
        existentEmployee.setLnameEmployee(employee.getLnameEmployee());
        existentEmployee.setCnpEmployee(employee.getCnpEmployee());
        existentEmployee.setPositionEmployee(employee.getPositionEmployee());
        existentEmployee.setSalaryEmployee(employee.getSalaryEmployee());
        existentEmployee.setEmploymentDate(employee.getEmploymentDate());
        existentEmployee.setBankEmployee(employee.getBankEmployee());

        employeesService.updateEmployee(existentEmployee);
        return "redirect:/employees";
    }

    @GetMapping("/employees/{idEmployee}")
    public String deleteEmployee(@PathVariable Long idEmployee){
        employeesService.deleteEmployeeByID(idEmployee);
        return "redirect:/employees";
    }
}
