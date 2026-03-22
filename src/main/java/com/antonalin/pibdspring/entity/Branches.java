package com.antonalin.pibdspring.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "Branches")
public class Branches {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idBranch")
    private long idBranch;

    @Column(name = "nameBranch",nullable = false)
    private String nameBranch;

    @Column(name = "cityBranch",nullable = false)
    private String cityBranch;

    @Column(name = "addressBranch",nullable = false)
    private String addressBranch;

    @Column(name = "phoneBranch",nullable = false)
    private String phoneBranch;

    @ManyToOne
    @JoinColumn(name= "bankBranch", nullable = false)
    private Bank bankBranch;

    public Branches(){}

    public Branches(String nameBranch, String cityBranch, String addressBranch, String phoneBranch, Bank bankBranch) {
       super();
        this.nameBranch = nameBranch;
        this.cityBranch = cityBranch;
        this.addressBranch = addressBranch;
        this.phoneBranch = phoneBranch;
        this.bankBranch = bankBranch;
    }

    //Getteri
    public long getIdBranch() {
        return idBranch;
    }

    public String getNameBranch() {
        return nameBranch;
    }

    public String getCityBranch() {
        return cityBranch;
    }

    public String getAddressBranch() {
        return addressBranch;
    }

    public String getPhoneBranch() {
        return phoneBranch;
    }

    public Bank getBankBranch() {
        return bankBranch;
    }


    //Setteri
    public void setIdBranch(long idBranch) {
        this.idBranch = idBranch;
    }

    public void setNameBranch(String nameBranch) {
        this.nameBranch = nameBranch;
    }

    public void setCityBranch(String cityBranch) {
        this.cityBranch = cityBranch;
    }

    public void setAddressBranch(String addressBranch) {
        this.addressBranch = addressBranch;
    }

    public void setPhoneBranch(String phoneBranch) {
        this.phoneBranch = phoneBranch;
    }

    public void setBankBranch(Bank bankBranch) {
        this.bankBranch = bankBranch;
    }
}
