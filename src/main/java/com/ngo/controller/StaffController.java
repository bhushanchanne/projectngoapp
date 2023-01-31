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
import com.ngo.dto.StaffDto;
import com.ngo.payloads.ApiResponse;
import com.ngo.service.StaffService;
import com.ngo.service.impl.StaffServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class StaffController {
	@Autowired
	private StaffService staffService;
	
	Logger logger= LoggerFactory.getLogger(StaffServiceImpl.class);
	
	@PostMapping("/staffadmin")
	public ResponseEntity<StaffDto> saveStaff(@RequestBody @Valid StaffDto staffDto){
		logger.info("Initiated request for save the Staff Details");
		StaffDto staff = this.staffService .saveStaff(staffDto);
		logger.info("Complited request for save the Staff Details ");		
	return new ResponseEntity<StaffDto>(staff,HttpStatus.CREATED) ;
		
	}
	@PutMapping("/{staffId}")
	public ResponseEntity<StaffDto>updateStaff(@Valid @RequestBody StaffDto staffDto,@PathVariable Long staffId){
		logger.info("Initiated request for Update the Staff Details ");
		StaffDto updateStaff = this.staffService.updateStaff(staffDto, staffId);
		logger.info("Complited request for Update the Staff Details ");
		
	return new ResponseEntity<StaffDto>(updateStaff,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/staff")
	public ResponseEntity<List<StaffDto>> getAllStaff(){
		logger.info("Initiated request for get all the Staff Details");
		List<StaffDto> allStaff = this.staffService.getAllStaff();
		logger.info("Completed request for get all the Staff Details");
	return new ResponseEntity<List<StaffDto>>(allStaff,HttpStatus.OK);  
		
			
	}
	
	
	 @DeleteMapping("/{staffId}")
		public ResponseEntity<ApiResponse> deleteStaff(@PathVariable Long staffId){
		 logger.info("Initiated request for Delete the Staff Details With ID");
			 this.staffService.deleteStaff(staffId);
		 logger.info("Completed request for Delete the Staff Details With ID ");	 
	return new ResponseEntity<ApiResponse>(new ApiResponse(AppConstants.STAFF_DELET,false),HttpStatus.OK);
			
	}
}