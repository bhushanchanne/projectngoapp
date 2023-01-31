 package com.ngo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ngo.constants.AppConstants;
import com.ngo.dto.AdminDto;
import com.ngo.payloads.ApiResponse;
import com.ngo.service.AdminService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api")

public class AdminController {
	
	
	@Autowired
	private AdminService adminService;
	
	Logger logger= LoggerFactory.getLogger(AdminController.class);
	/**
	 * @author Bhushan
	 * @apiNote This Api Is to save admin data
	 * @param adminDto
	 * @return
	 * 
	 * @
	 * 
	 * 
	 */
		
    
	@PostMapping("/admin")
	public ResponseEntity<AdminDto> saveAdmin(@RequestBody @Valid AdminDto adminDto) {
		logger.info("Initiated request for save the Admin Details ");//Simple Logger
		 AdminDto saveAdmin = this.adminService.saveAdmin(adminDto);
		 logger.info("Complited request for save the Admin Details ");
		
	return new ResponseEntity<AdminDto>(saveAdmin, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/admins")
	public ResponseEntity<List<AdminDto>> getAllAdmin(){
		logger.info("Initiated request for get all the Admin Details");
		List<AdminDto> allAdmin = this.adminService.getAllAdmin();
		logger.info("Completed request for get all the Admin Details");
				
	return new ResponseEntity<List<AdminDto>>(allAdmin, HttpStatus.OK);
		
	}
	
	 @PutMapping("/admin/{adminId}")
	public ResponseEntity<AdminDto> updateAdmin(@Valid @RequestBody AdminDto adminDto, @PathVariable Long adminId){
		 
		 logger.info("Initiated request for Update the Admin Details with adminID:{}", adminId);//logger with parameter
	    AdminDto updateAdmin = this.adminService.updateAdmin(adminDto, adminId);
	     logger.info("Initiated request for Update the Admin Details  with adminID:{}", adminId);
		 
	return new ResponseEntity<AdminDto>(updateAdmin, HttpStatus.CREATED);
		
	}
	
	 @DeleteMapping("/admin/{adminId}")
	public ResponseEntity<ApiResponse> deleteAdmin(@PathVariable Long adminId){
		 logger.info("Initiated request for delete the Admin Details with adminID:{}", adminId);
		 this.adminService.deleteAdmin(adminId);
		 logger.info("Initiated request for delete the Admin Details with adminID:{}", adminId);
				 
	return new ResponseEntity<ApiResponse>(new ApiResponse(AppConstants.ADMIN_DELETE,false),HttpStatus.OK);
		
	}
	
	
	
		
	
}
