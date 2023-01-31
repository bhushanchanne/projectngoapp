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

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Donar_DETAILS")
public class Donor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long donorId;
	
	@Column(name = "donor_name")
	private String donorName;

	@Column(name = "donor_contact")
	private String donorContact;
	
	@Column(name = "donor_pan")
	private String donorPan;
	
	@Column(name = "donor_gender")
	private String donorGender;
	
	@Column(name = "donor_dob")
	private String donorDOB;
	
	@Column(name = "donor_amount")
	private Long donorAmount;
	
	/**
	 * 
	 */
	@OneToOne(cascade = CascadeType.ALL)//Bidiretional Mappping
	@JoinColumn(name = "login_Id")
	private Login login;
	
	
	@Embedded
	private Address address;
	
	
	
	
	
}






