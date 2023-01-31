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
import com.ngo.dto.PartnerDto;
import com.ngo.payloads.ApiResponse;
import com.ngo.service.PartnerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class PartnerController {
	
	@Autowired
	private PartnerService partnerService;
	
	Logger logger=LoggerFactory.getLogger(PartnerController.class);
	
	
	@PostMapping("/partners")
	public ResponseEntity<PartnerDto> savePartner(@Valid @RequestBody PartnerDto partnerDto)
	{
		logger.info("Initiated request for save the Partner Details");
		PartnerDto savePartner = this.partnerService.savePartner(partnerDto);
		logger.info("Completed request for save the Partner Details");
		return new ResponseEntity<PartnerDto>(savePartner,HttpStatus.CREATED);
		
    }
	
	@GetMapping("/partners")
	public ResponseEntity<List<PartnerDto>> getAllPartner(){
		logger.info("Initiated request for get all the Partner Details");
		 List<PartnerDto> allPartner = this.partnerService.getAllPartner();
		 logger.info("Completed request for get all the Partner Details");
    return new ResponseEntity<>(allPartner, HttpStatus.OK);
		
	}
	
	@PutMapping("/partners/{partnerId}")
	public ResponseEntity<PartnerDto>  updateDonor(@Valid @RequestBody PartnerDto partnerDto,@PathVariable Long partnerId){
		logger.info("Initiated request for Update the Partner Details");
		PartnerDto updatePartner = this.partnerService.updatePartner(partnerDto, partnerId);
		logger.info("Completed request for Update the Partner Details");
	return  new ResponseEntity<>(updatePartner,HttpStatus.CREATED);
	
	}
	
	@DeleteMapping("/partners/{partnerId}")
	public ResponseEntity<ApiResponse>  deletePartner(@PathVariable Long partnerId){
		logger.info("Initiated request for Delete the Partner Details With ID");
	    this.partnerService.deletePartner(partnerId);
	    logger.info("Completed request for Delete the Partner Details With ID");
	return  new ResponseEntity<>(new ApiResponse(AppConstants.PARTNER_DELET, true),HttpStatus.OK);
	
	}
	 
		
		
	}
	
	
	


