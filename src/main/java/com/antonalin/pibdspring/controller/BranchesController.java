package com.antonalin.pibdspring.controller;

import com.antonalin.pibdspring.entity.Bank;
import com.antonalin.pibdspring.entity.Branches;
import com.antonalin.pibdspring.repository.BankRepository;
import com.antonalin.pibdspring.service.BranchesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BranchesController {
    private BranchesService BranchesService;

    @Autowired
    private BankRepository bankRepository;

    public BranchesController(BranchesService BranchesService) {
        super();
        this.BranchesService = BranchesService;
    }

    @GetMapping("/branches")
    public String listBranches(Model model){
        model.addAttribute("branches",BranchesService.getAllBranches());
        return "branches";
    }

    @GetMapping("/branches/new")
    public String createBranchesForm(Model model){
        List<Bank> allBanks = bankRepository.findAll();

        Branches Branches = new Branches();
        model.addAttribute("branches",Branches);
        model.addAttribute("allbanksemp",allBanks);

        return "create_branch";
    }

    @PostMapping("/branches")
    public String saveBranches(@ModelAttribute("branches") Branches Branches){
        BranchesService.saveBranch(Branches);
        return "redirect:/branches";
    }

    @GetMapping("/branches/edit/{idBranch}")
    public String editBranchesForm(@PathVariable Long idBranch,Model model){
        List<Bank> allBanks = bankRepository.findAll();

        model.addAttribute("branches",BranchesService.getBranchByID(idBranch));
        model.addAttribute("allbanksemp",allBanks);

        return "edit_branch";
    }

    @PostMapping("/branches/{idBranch}")
    public String updateBranches(@PathVariable Long idBranch, @ModelAttribute("branches") Branches Branches,Model model){
        Branches existentBranch = BranchesService.getBranchByID(idBranch);

        existentBranch.setIdBranch(idBranch);
        existentBranch.setNameBranch(Branches.getNameBranch());
        existentBranch.setCityBranch(Branches.getCityBranch());
        existentBranch.setAddressBranch(Branches.getAddressBranch());
        existentBranch.setPhoneBranch(Branches.getPhoneBranch());
        existentBranch.setBankBranch(Branches.getBankBranch());

        BranchesService.updateBranch(existentBranch);
        return "redirect:/branches";
    }

    @GetMapping("branches/{idBranch}")
    public String deleteBranch(@PathVariable Long idBranch){
        BranchesService.deleteBranchByID(idBranch);
        return "redirect:/branches";
    }
}
