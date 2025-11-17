package com.enquirysystem.enquirysystem.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EnquiryController {
	
	@GetMapping("/dashboard")
	public String dashboard() {
		return "dashboard";
	}
	@GetMapping("/viewenquiry")
	public String viewEnquiry() {
		return "viewenquiry";
	}
	@GetMapping("/addenquiry")
	public String addEnquiry() {
		return "addenquiry";
	}

}
