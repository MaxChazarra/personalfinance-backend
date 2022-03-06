package com.maxchazarra.personalfinancebackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maxchazarra.personalfinancebackend.models.ERole;
import com.maxchazarra.personalfinancebackend.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
