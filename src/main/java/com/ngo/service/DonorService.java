package com.ngo.service;

import java.util.List;

import com.ngo.dto.DonorDto;

public interface DonorService {

	DonorDto saveDonor(DonorDto donorDto);
	
	DonorDto updateDonor(DonorDto donorDto, Long donorId);
	
	 List<DonorDto> getAllDonor();
	
	 void deleteDonor(Long donorId);
	
	
}
