package com.enquirysystem.enquirysystem.Service;

import java.util.List;

import com.enquirysystem.enquirysystem.Bindings.DashboardResponse;
import com.enquirysystem.enquirysystem.Bindings.EnquiryForm;
import com.enquirysystem.enquirysystem.Bindings.EnquirySearchCriteria;

public interface EnquiryService {
	
	public String getCourseName();
	
	public String getEnquiryStatus();
	
	public DashboardResponse getDashboardData(Integer userId);
	
	public String addEnquiry(EnquiryForm form); 
	
	public List<EnquiryForm> getEnquiries(Integer userId,EnquirySearchCriteria searchCriteria); 

}
