package com.ngo.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngo.dto.LoginDto;
import com.ngo.repository.LoginRepository;
import com.ngo.service.LoginService;
@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public LoginDto getLogin(String loginUsername, String loginPassword) {
	             
    LoginDto login = this.loginRepository.getByLoginUsernameAndLoginPassword(loginUsername, loginPassword);          		
		
		return this.modelMapper.map(login,LoginDto.class);
	}

}
