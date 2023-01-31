package com.ngo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ngo.dto.LoginDto;
import com.ngo.dto.StaffDto;
import com.ngo.model.Staff;

public interface StaffRepository extends JpaRepository<Staff, Long>{
	
	StaffDto findByLogin(LoginDto login);
}
