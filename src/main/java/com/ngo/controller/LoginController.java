package com.ngo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ngo.dto.LoginDto;
import com.ngo.service.LoginService;
import com.ngo.service.StaffService;

@RestController
@RequestMapping("/login")
public class LoginController {
     
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private StaffService staffService;
	
	
	
	@GetMapping("get/{loginUsername}/{loginPassword}")
	public Object getLogin(@PathVariable String loginUsername,@PathVariable String loginPassword) {
		
		LoginDto login = this.loginService.getLogin(loginUsername, loginPassword);
		
		if(login.getLoginType().equalsIgnoreCase("staff")) {                  //staff,Staff,STAFF
			
			
			
			
			
			
		}   
		
		
		
		
		
		
		
		
		
		
		return login;
		
		
	}
	
}
