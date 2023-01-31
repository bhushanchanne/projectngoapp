package com.ngo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngo.constants.AppConstants;
import com.ngo.dto.LoginDto;
import com.ngo.dto.StaffDto;
import com.ngo.exception.ResourceNotFoundException;
import com.ngo.model.Staff;
import com.ngo.repository.StaffRepository;
import com.ngo.service.StaffService;
@Service
public class StaffServiceImpl implements StaffService{
	
	@Autowired
	private StaffRepository staffRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	Logger logger= LoggerFactory.getLogger(StaffServiceImpl.class);
	
	
	@Override
	public StaffDto saveStaff(StaffDto staffDto) {
		logger.info("Initiated request for save the Staff Details In DB");
        Staff staff = this.modelMapper.map(staffDto, Staff.class);
        Staff saveStaff = this.staffRepository.save(staff);
        StaffDto Staffdto = this.modelMapper.map(saveStaff, staffDto.getClass());
        logger.info("Complited request for save the Staff Details In DB ");
	return Staffdto;
	}

	@Override
	public StaffDto updateStaff(StaffDto staffDto, Long staffId) {
		logger.info("Initiated request for Update the Staff Details In DB ");
		Staff staff = this.staffRepository.findById(staffId)
				.orElseThrow(()-> new ResourceNotFoundException(AppConstants.NOT_FOUND1 + staffId));
		logger.info("Complited request for Update the Staff Details In DB ");
		staff.setStaffName(staffDto.getStaffName());
		staff.setStaffAadhar(staffDto.getStaffAadhar());
		staff.setStaffContact(staffDto.getStaffContact());
		staff.setStaffDepartment(staffDto.getStaffDepartment());
		staff.setStaffDesignation(staffDto.getStaffDesignation());
		staff.setStaffDOB(staffDto.getStaffDOB());
		staff.setStaffGender(staffDto.getStaffGender());
		
		Staff updatedStaff = this.staffRepository.save(staff);
		
		return this.modelMapper.map(updatedStaff, StaffDto.class);
	}

	@Override
	public List<StaffDto> getAllStaff() {
		logger.info("Initiated request for get all the Staff Details In DB");
		  List<Staff> listStaff = this.staffRepository.findAll();    
		  List<StaffDto> staffDtolist = listStaff.stream().map((staff)->this.modelMapper.map
				      	(staff, StaffDto.class)).collect(Collectors.toList());
		logger.info("Completed request for get all the Staff Details In DB");	
	return staffDtolist;
	
	}

	@Override
	public void deleteStaff(Long staffId) {
		logger.info("Initiated request for Delete the Staff Details With ID In DB");
		Staff staff = this.staffRepository.findById(staffId)
			.orElseThrow(()-> new ResourceNotFoundException(AppConstants.STAFF_DELET +staffId));
		logger.info("Completed request for Delete the Staff Details With ID In DB");
		this.staffRepository.delete(staff);
	}

	

	


}
