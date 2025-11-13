package com.enquirysystem.enquirysystem.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EnquiryController {
	
	@GetMapping("/dashboard")
	public String dashboard() {
		return "dashboard";
	}

}
