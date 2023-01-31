package com.ngo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="STAFF_DETAILS")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Staff {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long staffId;
	
	@Column(name="staff_name")
	private String staffName;
	
	@Column(name="staff_contact")
	private Long staffContact;
	
	@Column(name="staff_aadhar")
	private Long staffAadhar;
	
	@Column(name="staff_designation")
	private String staffDesignation;
	
	@Column(name="staff_department")
	private String staffDepartment;
	
	@Column(name="staff-gender")
	private String staffGender;
	
	@Column(name="staff_dob")
	private String staffDOB;
    
	
	@OneToOne(cascade = CascadeType.ALL)//Bidiretional Mappping
	@JoinColumn(name = "login_Id")
	private Login login;
	
	
	@Embedded
	private Address address;
}
