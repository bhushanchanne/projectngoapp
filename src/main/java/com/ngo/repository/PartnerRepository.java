package com.ngo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ngo.dto.LoginDto;
import com.ngo.dto.PartnerDto;
import com.ngo.model.Partner;

public interface PartnerRepository extends JpaRepository<Partner, Long>{
	
	PartnerDto findByLogin(LoginDto login);

}
