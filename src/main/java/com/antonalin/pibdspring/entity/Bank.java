package com.antonalin.pibdspring.entity;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="Bank")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idBank")
    private Long idBank;

    @Column(name = "nameBank",nullable = false)
    private String nameBank;

    @Column(name = "swiftCodeBank",nullable = false)
    private String swiftCodeBank;

    @Column(name = "cuiBank",nullable = false)
    private String cuiBank;

    @OneToMany(mappedBy = "bankEmployee",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Employees> bankEmployee;

    @OneToMany(mappedBy = "bankBranch",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Branches> bankBranch;

    public Bank(){}

    public Bank(String nume,String swift,String cui,Set<Employees> emp,Set<Branches> br){
        super();
        this.nameBank = nume;
        this.swiftCodeBank = swift;
        this.cuiBank = cui;
        this.bankBranch = br;
        this.bankEmployee = emp;
    }
    //Getteri
    public Long getIdBank(){
        return idBank;
    }
    public String getNameBank(){
        return nameBank;
    }
    public String getSwiftCodeBank(){
        return swiftCodeBank;
    }
    public String getCuiBank(){
        return cuiBank;
    }
    public Set<Employees> getBankEmployee(){
        return bankEmployee;
    }
    public Set<Branches> getBankBranch(){
        return bankBranch;
    }
    //Setteri
    public void setIdBank(Long idBank){
        this.idBank=idBank;
    }
    public void setNameBank(String name){
        this.nameBank = name;
    }
    public void setSwiftCodeBank(String swift){
        this.swiftCodeBank = swift;
    }
    public void setCuiBank(String cui){
        this.cuiBank = cui;
    }
    public void setBankEmployee(Set<Employees> emp){
        this.bankEmployee = emp;
    }
    public void setBankBranch(Set<Branches> br){
        this.bankBranch = br;
    }
}
