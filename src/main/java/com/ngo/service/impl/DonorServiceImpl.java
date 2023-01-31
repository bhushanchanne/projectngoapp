package com.ngo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngo.constants.AppConstants;
import com.ngo.dto.DonorDto;
import com.ngo.exception.ResourceNotFoundException;
import com.ngo.model.Donor;
import com.ngo.repository.DonorRepository;
import com.ngo.service.DonorService;

@Service
public class DonorServiceImpl implements DonorService {
	
	
	@Autowired
	private DonorRepository donorRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	Logger logger= LoggerFactory.getLogger(DonorServiceImpl.class);
	
	
	@Override
	public DonorDto saveDonor(DonorDto donorDto) {
		logger.info("Initiated request for save the Donor Details In DB");
		Donor donor = this.modelMapper.map(donorDto, Donor.class);
		Donor saveDonor = this.donorRepository.save(donor);
		logger.info("Complited request for save the Donor Details In DB ");		
	return this.modelMapper.map(saveDonor, DonorDto.class);
	}

	@Override
	public DonorDto updateDonor(DonorDto donorDto, Long donorId) {
		logger.info("Initiated request for Update the Donor Details In DB");
		Donor donor = this.donorRepository.findById(donorId)
				.orElseThrow(()-> new ResourceNotFoundException(AppConstants.NOT_FOUND+donorId));
		logger.info("Complited request for Update the Donor Details In DB ");
		donor.setDonorName(donorDto.getDonorName());
		donor.setDonorContact(donorDto.getDonorContact());
		donor.setDonorPan(donorDto.getDonorPan());
		donor.setDonorAmount(donorDto.getDonorAmount());
		donor.setDonorGender(donorDto.getDonorGender());
		donor.setDonorDOB(donorDto.getDonorDOB());
		
		 Donor updatedDonor = this.donorRepository.save(donor); 
		
		return this.modelMapper.map(updatedDonor, DonorDto.class);
	}

	@Override
	public List<DonorDto> getAllDonor() {
		logger.info("Initiated request for get all the Donor Details");
		List<Donor> donors = this.donorRepository.findAll();
		List<DonorDto> donorDtos = donors.stream().map((donor)-> this.modelMapper.map(donor, DonorDto.class)).collect(Collectors.toList());
		logger.info("Completed request for get all the Donor Details In DB");
		return donorDtos;
	}

	@Override
	public void deleteDonor(Long donorId) {
		logger.info("Initiated request for Delete the Donor Details With ID In DB");
		Donor donor = this.donorRepository.findById(donorId)
				.orElseThrow(()-> new ResourceNotFoundException(AppConstants.NOT_FOUND+donorId));
		logger.info("Completed request for Delete the Donor Details With ID In DB");
		this.donorRepository.delete(donor);
		
	}

}
