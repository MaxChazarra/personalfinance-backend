package com.maxchazarra.personalfinancebackend.repository;

import java.util.List;

import com.maxchazarra.personalfinancebackend.models.User;
import com.maxchazarra.personalfinancebackend.models.account.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByUsersUser(User user);
}
