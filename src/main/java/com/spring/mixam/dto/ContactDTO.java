package com.spring.mixam.dto;

import org.springframework.lang.Nullable;

import com.spring.mixam.validator.ValidPhoneNumber;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class ContactDTO {

	@NotEmpty(message="Name is required")
	private String name;
	
	@NotEmpty(message="Email is required")
	@Email(message="Incorrect Email Address")
	private String email;
	
	@NotEmpty(message="Phone number is required")
	@ValidPhoneNumber
	private String phoneNumber;
	
	@NotEmpty(message="Message is required")
	private String message;
	
	@Nullable
	private String companyName;
	
	@Nullable
	private String orderNumber;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	
}
