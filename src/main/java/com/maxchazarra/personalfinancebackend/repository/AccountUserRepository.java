package com.maxchazarra.personalfinancebackend.repository;

import com.maxchazarra.personalfinancebackend.models.account.AccountUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountUserRepository extends JpaRepository<AccountUser, Long> {

}
