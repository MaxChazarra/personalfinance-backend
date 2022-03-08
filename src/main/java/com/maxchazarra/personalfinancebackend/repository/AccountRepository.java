package com.maxchazarra.personalfinancebackend.repository;

import com.maxchazarra.personalfinancebackend.models.account.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
