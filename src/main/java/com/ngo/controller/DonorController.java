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
import com.ngo.dto.DonorDto;
import com.ngo.payloads.ApiResponse;
import com.ngo.service.DonorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class DonorController {
	
	@Autowired
	private DonorService donorService;
	
	Logger logger=LoggerFactory.getLogger(DonorController.class);
    
	@PostMapping("/donors")
	public ResponseEntity<DonorDto>saveDonor(@RequestBody @Valid DonorDto donorDto){
		logger.info("Initiated request for save the Donor Details ");
		DonorDto saveDonor = this.donorService.saveDonor(donorDto);
		logger.info("Complited request for save the Donor Details ");		
	return  new ResponseEntity<>(saveDonor,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/donors")
	public ResponseEntity<List<DonorDto>>getAllDonors(){
		logger.info("Initiated request for get all the Donor Details");
		List<DonorDto> allDonor = this.donorService.getAllDonor();
		logger.info("Completed request for get all the Donor Details");
		
		return new ResponseEntity<>(allDonor,HttpStatus.OK);
		
	}
	
	@PutMapping("/donors/{donorId}")
	public ResponseEntity<DonorDto>  updateDonor(@Valid @RequestBody DonorDto donorDto,@PathVariable Long donorId){
		logger.info("Initiated request for Update the Donor Details");
	    DonorDto updateDonor = this.donorService.updateDonor(donorDto, donorId);
	    logger.info("Completed request for Update the Donor Details");
	return  new ResponseEntity<>(updateDonor,HttpStatus.CREATED);
	
	}
	
	@DeleteMapping("/donor /{donorId}")
	public ResponseEntity<ApiResponse>  deleteDonor(@PathVariable Long donorId){
		logger.info("Initiated request for Delete the Donor Details With ID");
	    this.donorService.deleteDonor(donorId);
	    logger.info("Completed request for Delete the Donor Details With ID");
	return  new ResponseEntity<>(new ApiResponse(AppConstants.DONOR_DELET, true),HttpStatus.CREATED);
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
