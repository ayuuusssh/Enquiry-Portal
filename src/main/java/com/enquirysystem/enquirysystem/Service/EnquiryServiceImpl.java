package com.enquirysystem.enquirysystem.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enquirysystem.enquirysystem.Bindings.DashboardResponse;
import com.enquirysystem.enquirysystem.Bindings.EnquiryForm;
import com.enquirysystem.enquirysystem.Bindings.EnquirySearchCriteria;
import com.enquirysystem.enquirysystem.Entity.Courses;
import com.enquirysystem.enquirysystem.Entity.Enquiry_Status;
import com.enquirysystem.enquirysystem.Entity.Student_Enquiry;
import com.enquirysystem.enquirysystem.Entity.User_Details;
import com.enquirysystem.enquirysystem.Repository.CoursesRepo;
import com.enquirysystem.enquirysystem.Repository.EnquiryStatusRepo;
import com.enquirysystem.enquirysystem.Repository.StudentEnquiryRepo;
import com.enquirysystem.enquirysystem.Repository.UserDetailsRepo;

import jakarta.servlet.http.HttpSession;

@Service
public class EnquiryServiceImpl implements EnquiryService{
	
	@Autowired
	private UserDetailsRepo detailsRepo;
	
	@Autowired
	private CoursesRepo coursesRepo;
	
	@Autowired
	private EnquiryStatusRepo enqRepo;
	
	@Autowired
	private StudentEnquiryRepo studentRepo;
	
	@Autowired
	private HttpSession session;

	@Override
	public List<String> getCourseName() {
	  List<Courses> courses = coursesRepo.findAll();
	  
	  List<String> names = new ArrayList<>();
	  
	  for(Courses entity : courses) {
		  names.add(entity.getCourseName());
	  }
		return null;
	}

	@Override
	public List<String> getEnquiryStatus() {
		List<Enquiry_Status> enquiry = enqRepo.findAll();
		
		List<String> names = new ArrayList<>();
		
		for(Enquiry_Status entity : enquiry) {
			names.add(entity.getStatusName());
		}
		return null;
	}

	@Override
	public DashboardResponse getDashboardData(Integer userId) {
		 
		DashboardResponse response = new DashboardResponse();
		
	     Optional<User_Details> details = detailsRepo.findById(userId);
	     
	     if(details.isPresent()) {
	    	 User_Details user = details.get();
	    	 List<Student_Enquiry> enquiries =  user.getEnquiries();
	    	 Integer totalCount = enquiries.size();
	    	 
	    	 Integer enrolledCount =  enquiries.stream().filter(e -> e.getEnquiryStatus().equals("ENROLLED"))
	    	 .collect(Collectors.toList()).size();
	    	 
	    	 Integer lostCount = enquiries.stream().filter(e -> e.getEnquiryStatus().equals("LOST"))
	    	 .collect(Collectors.toList()).size();
	    	 
	    	 response.setTotalEnquiryCnt(totalCount);
	    	 response.setEnrollCnt(enrolledCount);
	    	 response.setLostCnt(lostCount);
	    	 
	     }
	     
		return null;
	}

	@Override
	public boolean saveEnquiry(EnquiryForm form) {
		Student_Enquiry enquiry = new Student_Enquiry();
		BeanUtils.copyProperties(form, enquiry);
		
		studentRepo.save(enquiry);
		
		Integer userId =  (Integer)session.getAttribute("userId");
		
		User_Details entity = detailsRepo.findById(userId).get();
		
		enquiry.setUser(entity);
		studentRepo.save(enquiry);
		
		return true;
	}

	@Override
	public List<EnquiryForm> getEnquiries(Integer userId, EnquirySearchCriteria searchCriteria) {
		// TODO Auto-generated method stub
		return null;
	}

}
