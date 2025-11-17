package com.enquirysystem.enquirysystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.enquirysystem.enquirysystem.Bindings.SignupForm;
import com.enquirysystem.enquirysystem.Service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("user", new SignupForm());
		return "signup";
	}
		
	@PostMapping("/signup")
	public String handleSignup(@ModelAttribute ("user")  SignupForm form , Model model) {
		boolean status = userService.signup(form);
		
		if(status) {
			model.addAttribute("succMSg", "Account Created check your Mail");
			
		}else {
			model.addAttribute("errorMsg", "Choose Unique Email");
		}
		return "signup";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
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
