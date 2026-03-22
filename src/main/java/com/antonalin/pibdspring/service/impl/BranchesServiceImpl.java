package com.antonalin.pibdspring.service.impl;

import com.antonalin.pibdspring.entity.Branches;
import com.antonalin.pibdspring.repository.BranchesRepository;
import com.antonalin.pibdspring.service.BranchesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchesServiceImpl implements BranchesService {
    private BranchesRepository BranchesRepository;

    public BranchesServiceImpl(BranchesRepository branchesRepository) {
        super();
        this.BranchesRepository = branchesRepository;
    }

    @Override
    public List<Branches> getAllBranches(){
        return BranchesRepository.findAll();
    }

    @Override
    public Branches saveBranch(Branches branch){
        return BranchesRepository.save(branch);
    }

    @Override
    public Branches getBranchByID(Long id){
        return BranchesRepository.findById(id).get();
    }

    @Override
    public Branches updateBranch(Branches branch){
        return BranchesRepository.save(branch);
    }

    @Override
    public void deleteBranchByID(Long id){
        BranchesRepository.deleteById(id);
    }
}
