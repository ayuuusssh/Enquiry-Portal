package com.enquirysystem.enquirysystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.enquirysystem.enquirysystem.Bindings.DashboardResponse;
import com.enquirysystem.enquirysystem.Bindings.EnquiryForm;
import com.enquirysystem.enquirysystem.Entity.Enquiry_Status;
import com.enquirysystem.enquirysystem.Service.EnquiryService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EnquiryController {
	@Autowired
	private EnquiryService enquiryService;
	@Autowired
	private HttpSession session;
	
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		Integer userId = (Integer)session.getAttribute("userId");
		DashboardResponse dashboardData = enquiryService.getDashboardData(userId);
		model.addAttribute("dashboardData", dashboardData);
		return "dashboard";
	}
	
	@GetMapping("/viewenquiry")
	public String viewEnquiry() {
		return "viewenquiry";
	}
	
	@GetMapping("/addenquiry")
	public String addEnquiry(Model model) {
		List<String> courses = enquiryService.getCourseName();
		
		List<String> enquiries = enquiryService.getEnquiryStatus();
		
		EnquiryForm form = new EnquiryForm();
		
		model.addAttribute("coursesName", courses);
		model.addAttribute("enquiryStatus", enquiries);
		model.addAttribute("form", form);
		
		
		return "addenquiry";
	}
	
	@PostMapping("/addenquiry")
	public String addEnquiry(@ModelAttribute ("form") EnquiryForm form, Model model) {
		
		boolean status = enquiryService.saveEnquiry(form);
		if(status) {
			model.addAttribute("sucessMsg", "Enquiry Added");
		}else {
			model.addAttribute("errMsg", "Error while adding Enquiry");
		}
		return "addenquiry";
	}
	
	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		return "index";
	}

}
