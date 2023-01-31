package com.ngo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AdminDto {
 	
	private Long adminId;
	
	@NotEmpty
	@Size(min=3,max=5,message = "Name Must Be Atleast 3 Character..")
	private String adminName;

	@NotNull
	@Size(min=10,max=10,message = "Not Valid ADMIN_CONTACT..")
	private Long adminContact;
	
	@NotNull
	@Size(min=12,max=12,message = "Aadhar Card Must Be 12 Digit..")
	private Long adminAadhar;
	
	@NotEmpty
	private String adminGender;

}
