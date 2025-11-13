package com.enquirysystem.enquirysystem.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}
	@GetMapping("/forgotpwd")
	public String forgotPwd() {
		return "forgotpwd";
	}
	@GetMapping("/unlockpage")
	public String unlockPage() {
		return "unlockpage";
	}

}
