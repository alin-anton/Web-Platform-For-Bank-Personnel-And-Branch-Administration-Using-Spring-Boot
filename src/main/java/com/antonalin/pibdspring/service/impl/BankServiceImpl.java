package com.antonalin.pibdspring.service.impl;


import com.antonalin.pibdspring.entity.Bank;
import com.antonalin.pibdspring.repository.BankRepository;
import com.antonalin.pibdspring.service.BankService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankServiceImpl implements BankService {
    private BankRepository BankRepository;

    public BankServiceImpl(BankRepository bankRepository) {
        super();
        this.BankRepository = bankRepository;
    }

    @Override
    public List<Bank> getAllBanks(){
        return BankRepository.findAll();
    }

    @Override
    public Bank saveBank(Bank banca){
        return BankRepository.save(banca);
    }

    @Override
    public Bank getBankByID(Long idbanca){
        return BankRepository.findById(idbanca).get();
    }

    @Override
    public Bank updateBank(Bank banca){
        return BankRepository.save(banca);
    }

    @Override
    public void deleteBankByID(Long idbanca){
        BankRepository.deleteById(idbanca);
    }
}
