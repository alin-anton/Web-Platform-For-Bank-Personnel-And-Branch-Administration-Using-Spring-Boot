package com.antonalin.pibdspring.service;

import com.antonalin.pibdspring.entity.Bank;

import java.util.List;

public interface BankService {
    List<Bank> getAllBanks();

    Bank saveBank(Bank banca);

    Bank getBankByID(Long idbanca);

    Bank updateBank(Bank banca);

    void deleteBankByID(Long idbanca);

}
