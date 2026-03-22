package com.antonalin.pibdspring.controller;

import com.antonalin.pibdspring.entity.Bank;
import com.antonalin.pibdspring.service.BankService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BankController {
    private BankService BankService;

    public BankController(BankService BankService) {
        super();
        this.BankService = BankService;
    }

    @GetMapping("/bank")
    public String listBank(Model model){
        model.addAttribute("bank",BankService.getAllBanks());
        return "bank";
    }

    @GetMapping("/bank/new")
    public String createNewBank(Model model){
        Bank bank = new Bank();
        model.addAttribute("bank",bank);
        return "create_bank";
    }

    @PostMapping("/bank")
    public String saveBank(@ModelAttribute("bank") Bank bank){
        BankService.saveBank(bank);
        return "redirect:/bank";
    }

    @GetMapping("/bank/edit/{idBank}")
    public String editBankForm(@PathVariable Long idBank, Model model){
        model.addAttribute("bank",BankService.getBankByID(idBank));
        return "edit_bank";
    }

    @PostMapping("/bank/{idBank}")
    public String updateBank(@PathVariable Long idBank, @ModelAttribute("bank") Bank bank,Model model){
        Bank existentBank = BankService.getBankByID(idBank);
        existentBank.setIdBank(idBank);
        existentBank.setNameBank(bank.getNameBank());
        existentBank.setCuiBank(bank.getCuiBank());
        existentBank.setSwiftCodeBank(bank.getSwiftCodeBank());

        BankService.updateBank(existentBank);
        return "redirect:/bank";
    }

    @GetMapping("/bank/{idBank}")
    public String deleteBank(@PathVariable Long idBank){
        BankService.deleteBankByID(idBank);
        return "redirect:/bank";
    }
}
