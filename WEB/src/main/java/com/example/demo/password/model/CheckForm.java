package com.example.demo.password.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class CheckForm {

	@Email
	@NotBlank
	private String userMail;

	private String password;
}
