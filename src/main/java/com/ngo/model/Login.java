 package com.ngo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "LOGIN_DETAILS")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Login {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long loginId;
	
	@Column(name = "login_username")
	private String loginUsername;
	
	@Column(name = "login_password")
	private String loginPassword;
	
	@Column(name = "login_type")
	private String loginType;
	


}
