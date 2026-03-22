package com.antonalin.pibdspring.repository;

import com.antonalin.pibdspring.entity.Branches;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchesRepository extends JpaRepository<Branches,Long> {
}
