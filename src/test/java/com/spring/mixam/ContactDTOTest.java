package com.spring.mixam;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.spring.mixam.dto.ContactDTO;

import jakarta.validation.ConstraintViolation;

@SpringBootTest
class ContactDTOTest {

	@Autowired
	private LocalValidatorFactoryBean validator;
	
	@Test
	public void testContactDTOAllNull() {
		ContactDTO form = new ContactDTO();
		form.setName(null);
		form.setPhoneNumber(null);
		form.setCompanyName(null);
		form.setEmail(null);
		form.setMessage(null);
		form.setOrderNumber(null);
		
		Set<ConstraintViolation<ContactDTO>> violations = validator.validate(form);
		
		assertThat(violations.size()).isEqualTo(5);
	}
	
	@Test
	public void testContactDTONameNotNull() {
		ContactDTO form = new ContactDTO();
		form.setName("John Cena");
		form.setPhoneNumber(null);
		form.setCompanyName(null);
		form.setEmail(null);
		form.setMessage(null);
		form.setOrderNumber(null);
		
		Set<ConstraintViolation<ContactDTO>> violations = validator.validate(form);		
		
		assertThat(violations.size()).isEqualTo(4);
	}
	
	@Test
	public void testContactDTOPhoneNumberNotNullButInvalid() {
		ContactDTO form = new ContactDTO();
		form.setName("John Cena");
		form.setPhoneNumber("1234567890");
		form.setCompanyName(null);
		form.setEmail(null);
		form.setMessage(null);
		form.setOrderNumber(null);
		
		Set<ConstraintViolation<ContactDTO>> violations = validator.validate(form);
		
		assertThat(violations.size()).isEqualTo(3);
	}
	
	@Test
	public void testContactDTOPhoneNumberNotNullValid() {
		ContactDTO form = new ContactDTO();
		form.setName("John Cena");
		form.setPhoneNumber("123-456-7890");
		form.setCompanyName(null);
		form.setEmail(null);
		form.setMessage(null);
		form.setOrderNumber(null);
		
		Set<ConstraintViolation<ContactDTO>> violations = validator.validate(form);
		
		assertThat(violations.size()).isEqualTo(2);
	}
	
	@Test
	public void testContactDTOEmailNotNullButInvalid() {
		ContactDTO form = new ContactDTO();
		form.setName("John Cena");
		form.setPhoneNumber("123-456-7890");
		form.setCompanyName(null);
		form.setEmail("john.cena");
		form.setMessage(null);
		form.setOrderNumber(null);
		
		Set<ConstraintViolation<ContactDTO>> violations = validator.validate(form);
		
		assertThat(violations.size()).isEqualTo(2);
	}
	
	@Test
	public void testContactDTOEmailNotNullValid() {
		ContactDTO form = new ContactDTO();
		form.setName("John Cena");
		form.setPhoneNumber("123-456-7890");
		form.setCompanyName(null);
		form.setEmail("john.cena@gmail.com");
		form.setMessage(null);
		form.setOrderNumber(null);
		
		Set<ConstraintViolation<ContactDTO>> violations = validator.validate(form);
		
		assertThat(violations.size()).isEqualTo(1);
	}
	
	@Test
	public void testContactDTOMessageNotNull() {
		ContactDTO form = new ContactDTO();
		form.setName("John Cena");
		form.setPhoneNumber("123-456-7890");
		form.setCompanyName(null);
		form.setEmail("john.cena@gmail.com");
		form.setMessage("I'm JOHN CENA!!");
		form.setOrderNumber(null);
		
		Set<ConstraintViolation<ContactDTO>> violations = validator.validate(form);
		
		assertThat(violations.size()).isEqualTo(0);
	}

}
