package com.enquirysystem.enquirysystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.enquirysystem.enquirysystem.Bindings.LoginForm;
import com.enquirysystem.enquirysystem.Bindings.SignupForm;
import com.enquirysystem.enquirysystem.Bindings.UnlockForm;
import com.enquirysystem.enquirysystem.Service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private HttpSession session;
	
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
	public String login(Model model) {
		model.addAttribute("loginForm",new LoginForm());
		return "login";
	}
	
	@PostMapping("/login")
	public String loginAccount(@ModelAttribute ("login") LoginForm form, Model model) {
		String login = userService.login(form);
		if(login.contains("success")) {
			return "redirect:/dashboard";
		}
		model.addAttribute("errMsg",login);
		return "login";
	}
	
	
	@GetMapping("/forgotpwd")
	public String forgotPwd() {
		return "forgotpwd";
	}
	
	@PostMapping("/forgotpwd")
	public boolean forgotPwd(@RequestParam ("email") String email, Model model) {
		boolean status = userService.forgot(email);
		if(status) {
			model.addAttribute("sucessMsg", "Password send to your mail");
		}else {
			model.addAttribute("errMsg", "Invalid Mail");
		}
		return true;
	}
	
	
	@GetMapping("/unlockpage")
	public String unlockPage(@RequestParam String email, Model model) {
		UnlockForm unlock = new UnlockForm();
		unlock.setEmail(email);
		model.addAttribute("unlock", unlock);
		return "unlockpage";
	}
	
	@PostMapping("/unlockpage")
	public String unlockUserAccount(@ModelAttribute ("unlock") UnlockForm form, Model model) {
		
		if(form.getNewPwd().equals(form.getConfirmPwd())) {
			boolean status = userService.unlockAccount(form);
			if(status) {
				model.addAttribute("successMsg", "Account unlocked successfully");
			}else {
				model.addAttribute("errMsg","Invalid Credentials");
			}
		}else {
			model.addAttribute("errMsg","New Password and Confirm Password must be same");	
		}
		return "unlock";
	}
}
