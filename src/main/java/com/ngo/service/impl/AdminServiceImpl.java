package com.ngo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngo.constants.AppConstants;
import com.ngo.dto.AdminDto;
import com.ngo.exception.ResourceNotFoundException;
import com.ngo.model.Admin;
import com.ngo.repository.AdminRepository;
import com.ngo.service.AdminService;

@Service

public class AdminServiceImpl implements AdminService{
	
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	Logger logger=LoggerFactory.getLogger(AdminServiceImpl.class);

	@Override
	public AdminDto saveAdmin(AdminDto adminDto) {
		 //Frontend Request in adminDto , Database-Admin
		logger.info("Initiating Dao Call for the save the admin users");
		Admin admin = this.modelMapper.map(adminDto, Admin.class);
		Admin saveAdmin = this.adminRepository.save(admin);
		logger.info("Completed Dao call for the save Admin Users");
		
		//AdminDto map = this.modelMapper.map(saveAdmin , AdminDto.class);
						
	return this.modelMapper.map(saveAdmin , AdminDto.class);
	
	}

	@Override
	public AdminDto updateAdmin(AdminDto adminDto, Long adminId) {
		logger.info("Initiating Dao Call for the update the Admin Details With :{}",adminId);
		Admin admin = this.adminRepository.findById(adminId)
			.orElseThrow(()-> new ResourceNotFoundException(AppConstants.NOT_FOUND+adminId));
		 admin.setAdminName(adminDto.getAdminName());
		 admin.setAdminContact(adminDto.getAdminContact());
		 admin.setAdminGender(adminDto.getAdminGender());
		 admin.setAdminAadhar(adminDto.getAdminAadhar());
		
	   Admin updatedadmin = this.adminRepository.save(admin);
	   logger.info("Completed Dao Call for the update the Admin Details With :{}",adminId);
		 
		// AdminDto updatedadmin1 = this.modelMapper.map(updatedadmin, AdminDto.class);
		 		 
	return this.modelMapper.map(updatedadmin, AdminDto.class);
	
	}
	
	
	//Entity or model class always communicate with DB
	//Dto class Always communicate with UI or Front End
	
	
	@Override
	public List<AdminDto> getAllAdmin() {
		logger.info("Initiated request for get all the Admin Details");
	    List<Admin> listAdmin = this.adminRepository.findAll();    
		List<AdminDto> listDtos = listAdmin.stream().map((admin)->this.modelMapper.map
			                    (admin, AdminDto.class)).collect(Collectors.toList());
	    logger.info("Completed request for get all the Admin Details");
	return listDtos;
	
	}

	@Override
	public void deleteAdmin(Long adminId) {
		logger.info("Initiated request for Delete the Admin Details With ID");
		Admin admin = this.adminRepository.findById(adminId)
				.orElseThrow(()-> new ResourceNotFoundException(AppConstants.ADMIN_DELETE + adminId));
		logger.info("Completed request for Delete the Admin Details With ID");
		this.adminRepository.delete(admin);
		
	}

}
