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
@Table(name = "Partner_Details")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
  public class Partner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long partnerId;
	
	@Column(name = "partner_organization")
	private String partnerOrganization;
	
	@Column(name = "partner_contact")
	private String partnerContact;
	
	@Column(name = "partner_website")
	private String partnerWebsite;
	
	

	@OneToOne(cascade = CascadeType.ALL)//Bidiretional Mappping
	@JoinColumn(name = "login_Id")
	private Login login;
	
	@Embedded
	private Address address;
}
