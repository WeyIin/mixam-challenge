package com.spring.mixam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.mixam.dto.ContactDTO;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/contact")
public class ContactController {

	@GetMapping()
	public String displayContactForm(Model model) {
		model.addAttribute("form", new ContactDTO());
		return "contactUs";
	}
	
	@PostMapping()
	public String contactFormPost(@Valid @ModelAttribute("form") ContactDTO form, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "contactUs";
		}
		
		model.addAttribute("success", true);
		return "contactUs";
	}
	
}
