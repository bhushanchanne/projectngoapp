package com.ngo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngo.constants.AppConstants;
import com.ngo.dto.PartnerDto;
import com.ngo.exception.ResourceNotFoundException;
import com.ngo.model.Partner;
import com.ngo.repository.PartnerRepository;
import com.ngo.service.PartnerService;
@Service
public class PartnerServiceImpl implements PartnerService{

	@Autowired
	private PartnerRepository partnerRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	Logger logger= LoggerFactory.getLogger(DonorServiceImpl.class);
	
	@Override
	public PartnerDto savePartner(PartnerDto partnerDto) {
	  logger.info("Initiated request for save the Partner Details");
         Partner partner = this.modelMapper.map(partnerDto, Partner.class);		
		Partner savePartner = this.partnerRepository.save(partner);
		logger.info("Completed request for save the Partner Details");
	return this.modelMapper.map(savePartner,PartnerDto.class);
		
	}

	@Override
	public PartnerDto updatePartner(PartnerDto partnerDto, Long partnerId) {
		logger.info("Initiated request for Update the Partner Details");
		Partner partner = this.partnerRepository.findById(partnerId)
		     .orElseThrow(()-> new ResourceNotFoundException(AppConstants.NOT_FOUND+partnerId));
		partner.setPartnerWebsite(partnerDto.getPartnerWebsite());
		partner.setPartnerOrganization(partnerDto.getPartnerOrganization());
		partner.setPartnerContact(partnerDto.getPartnerContact());
		
		Partner updatedpartner = this.partnerRepository.save(partner);
		logger.info("Completed request for Update the Partner Details");
		
	return this.modelMapper.map(updatedpartner, PartnerDto.class);

	}

	@Override
	public List<PartnerDto> getAllPartner() {
		logger.info("Initiated request for get all the Partner Details");
		List<Partner> partners = this.partnerRepository.findAll();
		List<PartnerDto> partnerDtos = partners.stream()
			.map((partner)->this.modelMapper.map(partners,PartnerDto.class)).collect(Collectors.toList());
		logger.info("Completed request for get all the Partner Details");
		
	return partnerDtos;
	
	}
	

	@Override
	public void deletePartner(Long partnerId) {
		logger.info("Initiated request for Delete the Partner Details With ID");
		Partner partner = this.partnerRepository.findById(partnerId)
			     .orElseThrow(()-> new ResourceNotFoundException(AppConstants.NOT_FOUND+partnerId));
		  logger.info("Completed request for Delete the Partner Details With ID");
		this.partnerRepository.delete(partner);
		
	}

}
