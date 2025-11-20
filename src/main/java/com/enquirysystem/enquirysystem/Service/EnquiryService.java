package com.enquirysystem.enquirysystem.Service;

import java.util.List;

import com.enquirysystem.enquirysystem.Bindings.DashboardResponse;
import com.enquirysystem.enquirysystem.Bindings.EnquiryForm;
import com.enquirysystem.enquirysystem.Bindings.EnquirySearchCriteria;

public interface EnquiryService {
	
	public List<String> getCourseName();
	
	public List<String> getEnquiryStatus();
	
	public DashboardResponse getDashboardData(Integer userId);
	
	public boolean saveEnquiry(EnquiryForm form); 
	
	public List<EnquiryForm> getEnquiries(Integer userId,EnquirySearchCriteria searchCriteria); 

}
