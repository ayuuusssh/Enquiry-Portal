package com.enquirysystem.enquirysystem.Utils;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import com.enquirysystem.enquirysystem.Entity.Courses;
import com.enquirysystem.enquirysystem.Entity.Enquiry_Status;
import com.enquirysystem.enquirysystem.Repository.CoursesRepo;
import com.enquirysystem.enquirysystem.Repository.EnquiryStatusRepo;

public class DataRunner implements ApplicationRunner {
	
	@Autowired
	private CoursesRepo coursesRepo;
	@Autowired
	private EnquiryStatusRepo enqRepo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		coursesRepo.deleteAll();
		
	  Courses c1 = new Courses();
	  c1.setCourseName("JAVA");
	  
	  Courses c2 = new Courses();
	  c2.setCourseName("AWS");
	  
	  Courses c3 = new Courses();
	  c3.setCourseName("DEV-OOPs");
	  
	  Courses c4 = new Courses();
	  c4.setCourseName("JavaSCript");
	  
	  
	  coursesRepo.saveAll(Arrays.asList(c1,c2,c3,c4));
	  
	  Enquiry_Status a1 = new Enquiry_Status();
	  a1.setStatusName("NEW");
	  
	  Enquiry_Status a2 = new Enquiry_Status();
	  a2.setStatusName("ENROLLED");
	  
	  Enquiry_Status a3 = new Enquiry_Status();
	  a3.setStatusName("LOST");
	  
	  enqRepo.saveAll(Arrays.asList(a1,a2,a3));
	  
	  
	}

}
