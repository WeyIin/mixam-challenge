package com.spring.mixam.validator;

import org.springframework.beans.factory.annotation.Configurable;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Configurable
public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		//this only checks if the number is correct FORMAT.
		//e.g. 888-510-1456 should be valid.
		if (value == null) {
			return false;
		}
		return value.matches("^(\\([0-9]{3}\\) |[0-9]{3}-)[0-9]{3}-[0-9]{4}$");
	}
}
