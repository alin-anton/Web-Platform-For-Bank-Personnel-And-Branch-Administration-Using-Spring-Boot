package com.antonalin.pibdspring.repository;

import com.antonalin.pibdspring.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank,Long> {
}
