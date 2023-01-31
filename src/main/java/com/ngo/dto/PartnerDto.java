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
public class PartnerDto {
	
	
	
	private Long partnerId;
	 @NotEmpty
		@Size(min=2,message = "Name Must Be Atleast 3 Character..")
	private String partnerOrganization;
	
	 @NotNull
		@Size(min=10,max=10,message = "Not Valid ADMIN_CONTACT..")
	private String partnerContact;
	  
	 
	 @NotEmpty
	 @Pattern(regexp =("((http|https)://)(www.)?[a-zA-Z0-9@:%._\\+~#?&//=]{2,256}"
	 		+ "\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%._\\+~#?&//=]*)"),message = "Website URL is not Proper..")
	private String partnerWebsite; 


}
