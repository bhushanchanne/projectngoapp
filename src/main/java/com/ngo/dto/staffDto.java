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
public class StaffDto {
	
    private Long staffId;
	
    
    @NotEmpty
	@Size(min=3,max=5,message = "Name Must Be Atleast 3 Character..")
	private String staffName;
	
    
    @NotNull
	@Size(min=10,max=10,message = "Not Valid ADMIN_CONTACT..")
	private Long staffContact;
	
    @NotNull
	@Size(min=12,max=12,message = "Aadhar Card Must Be 12 Digit..")
    private Long staffAadhar;
	
    @NotEmpty
	private String staffDesignation;
    @NotEmpty
	private String staffDepartment;
    @NotEmpty
	private String staffGender;
    @NotEmpty
	private String staffDOB;

}
