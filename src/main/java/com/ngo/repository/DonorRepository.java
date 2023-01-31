package com.ngo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ngo.dto.DonorDto;
import com.ngo.dto.LoginDto;
import com.ngo.model.Donor;

public interface DonorRepository extends JpaRepository<Donor, Long>{
	
	DonorDto findByLogin(LoginDto login);

}
