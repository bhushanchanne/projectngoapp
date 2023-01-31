package com.ngo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DonorDto {
	
    private Long donorId;
    @NotEmpty
	@Size(min=3,max=5,message = "Name Must Be Atleast 3 Character..")
	private String donorName;

    @NotNull
	@Size(min=10,max=10,message = "Not Valid ADMIN_CONTACT..")
	private String donorContact;
	
	@NotEmpty
	@Size(min=10,max=10,message = "PAN_CARD must be 10 Digit.. ")
	@Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}")
	private String donorPan;
	
	@NotEmpty
	private String donorGender;
	
	@NotEmpty
	private String donorDOB;
	
	@NotEmpty
	private Long donorAmount;

}
