package com.ngo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
	
    private Long loginId;
    
    @NotEmpty
	private String loginUsername;
	
    
//                                     @Pattern(regexp = "^ ((?=.* [a-z]) (?=.* [A-Z]) (?=.* [!@#$&*]) (?=.* [0-9])) {4,12}$",
//                                     message = "password must contain atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit ")
    @NotEmpty
    private String loginPassword;
	
    
    @NotEmpty
	private String loginType;

}
