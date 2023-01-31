package com.ngo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ngo.dto.AdminDto;
import com.ngo.dto.LoginDto;
import com.ngo.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

	AdminDto findByLogin(LoginDto login);



}
