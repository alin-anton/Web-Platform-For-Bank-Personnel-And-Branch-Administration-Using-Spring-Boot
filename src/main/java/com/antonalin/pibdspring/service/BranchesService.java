package com.antonalin.pibdspring.service;

import com.antonalin.pibdspring.entity.Branches;

import java.util.List;

public interface BranchesService {
    List<Branches> getAllBranches();

    Branches saveBranch(Branches branch);

    Branches getBranchByID(Long id);

    Branches updateBranch(Branches branch);

    void deleteBranchByID(Long id);
}
