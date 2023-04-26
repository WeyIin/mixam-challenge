package com.spring.mixam;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import com.spring.mixam.controller.ContactController;
import com.spring.mixam.dto.ContactDTO;

@WebMvcTest(ContactController.class)
public class ContactControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	private static ContactDTO form = new ContactDTO();
	
	@BeforeAll
	public static void createForm() {
		form.setName("John Cena");
		form.setEmail("john.cena@gmail.com");
		form.setPhoneNumber("123-456-7890");
		form.setMessage("I'm JOHN CENA!!");
	}
	
	@AfterAll
	public static void teardown() {
		form = null;
	}

	@Test
	public void formPageShouldBeDisplayed() throws Exception {
		this.mockMvc.perform(get("/contact")).andExpect(status().isOk())
				.andExpect(content().string(containsString("<title>Contact Us</title>")));
	}
	
	@Test
	public void formSubmitSuccess() throws Exception {
		this.mockMvc.perform(post("/contact")
				.param("name", form.getName())
				.param("email", form.getEmail())
				.param("phoneNumber", form.getPhoneNumber())
				.param("message", form.getMessage())
				)
				.andExpect(content().string(containsString("Thank You")));
	}
	
	@Test
	public void formSubmitFailName() throws Exception {
		this.mockMvc.perform(post("/contact")
				.param("name", "")
				.param("email", form.getEmail())
				.param("phoneNumber", form.getPhoneNumber())
				.param("message", form.getMessage())
				)
				.andExpect(content().string(containsString("Name is required")));
	}
	
	@Test
	public void formSubmitFailIncorrectEmail() throws Exception {
		this.mockMvc.perform(post("/contact")
				.param("name", form.getName())
				.param("email", "john.cena")
				.param("phoneNumber", form.getPhoneNumber())
				.param("message", form.getMessage())
				)
				.andExpect(content().string(containsString("Incorrect Email Address")));
	}
	
	@Test
	public void formSubmitFailEmptyEmail() throws Exception {
		this.mockMvc.perform(post("/contact")
				.param("name", form.getName())
				.param("email", "")
				.param("phoneNumber", form.getPhoneNumber())
				.param("message", form.getMessage())
				)
				.andExpect(content().string(containsString("Email is required")));
	}
	
	@Test
	public void formSubmitFailEmptyPhoneNumber() throws Exception {
		this.mockMvc.perform(post("/contact")
				.param("name", form.getName())
				.param("email", form.getEmail())
				.param("phoneNumber", "")
				.param("message", form.getMessage())
				)
				.andExpect(content().string(containsString("Phone number is required")));
	}
	
	@Test
	public void formSubmitFailIncorrectPhoneNumber() throws Exception {
		this.mockMvc.perform(post("/contact")
				.param("name", form.getName())
				.param("email", form.getEmail())
				.param("phoneNumber", "1234-567-890")
				.param("message", form.getMessage())
				)
				.andExpect(content().string(containsString("Invalid phone number")));
	}
	
	@Test
	public void formSubmitFailEmptyMessage() throws Exception {
		this.mockMvc.perform(post("/contact")
				.param("name", form.getName())
				.param("email", form.getEmail())
				.param("phoneNumber", form.getPhoneNumber())
				.param("message", "")
				)
				.andExpect(content().string(containsString("Message is required")));
	}
}
