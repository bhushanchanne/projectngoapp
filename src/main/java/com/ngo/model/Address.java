package com.ngo.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address {

	private String area;
	private String city;
	private String state;
	private String country;
	private String pincode;

	
	
	
	
}
