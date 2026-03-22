package com.antonalin.pibdspring.entity;


import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Employees")
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEmployee")
    private long idEmployee;

    @Column(name = "fnameEmployee",nullable = false)
    private String fnameEmployee;

    @Column(name = "lnameEmployee",nullable = false)
    private String lnameEmployee;

    @Column(name = "cnpEmployee",nullable = false)
    private String cnpEmployee;

    @Column(name = "positionEmployee",nullable = false)
    private String positionEmployee;

    @Column(name = "salaryEmployee",nullable = false,precision = 15,scale = 2)
    private BigDecimal salaryEmployee;

    @Column(name = "employmentDate",nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date employmentDate;

    @ManyToOne
    @JoinColumn(name = "bankEmployee",nullable = false)
    private Bank bankEmployee;

    public Employees(){}

    public Employees(String fnameEmployee, String lnameEmployee, String cnpEmployee, String positionEmployee, BigDecimal salaryEmployee, Date employmentDate, Bank bankEmployee) {
        super();
        this.fnameEmployee = fnameEmployee;
        this.lnameEmployee = lnameEmployee;
        this.cnpEmployee = cnpEmployee;
        this.positionEmployee = positionEmployee;
        this.salaryEmployee = salaryEmployee;
        this.employmentDate = employmentDate;
        this.bankEmployee = bankEmployee;
    }

    //Getteri
    public long getIdEmployee() {
        return idEmployee;
    }

    public String getFnameEmployee() {
        return fnameEmployee;
    }

    public String getLnameEmployee() {
        return lnameEmployee;
    }

    public String getCnpEmployee() {
        return cnpEmployee;
    }

    public String getPositionEmployee() {
        return positionEmployee;
    }

    public BigDecimal getSalaryEmployee() {
        return salaryEmployee;
    }

    public Date getEmploymentDate() {
        return employmentDate;
    }

    public Bank getBankEmployee() {
        return bankEmployee;
    }

    //Setteri
    public void setIdEmployee(long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public void setFnameEmployee(String fnameEmployee) {
        this.fnameEmployee = fnameEmployee;
    }

    public void setLnameEmployee(String lnameEmployee) {
        this.lnameEmployee = lnameEmployee;
    }

    public void setCnpEmployee(String cnpEmployee) {
        this.cnpEmployee = cnpEmployee;
    }

    public void setPositionEmployee(String positionEmployee) {
        this.positionEmployee = positionEmployee;
    }

    public void setSalaryEmployee(BigDecimal salaryEmployee) {
        this.salaryEmployee = salaryEmployee;
    }

    public void setEmploymentDate(Date employmentDate) {
        this.employmentDate = employmentDate;
    }

    public void setBankEmployee(Bank bankEmployee) {
        this.bankEmployee = bankEmployee;
    }
}
