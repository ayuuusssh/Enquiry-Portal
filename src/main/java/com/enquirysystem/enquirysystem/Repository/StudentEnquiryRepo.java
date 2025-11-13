package com.enquirysystem.enquirysystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enquirysystem.enquirysystem.Entity.Student_Enquiry;

@Repository
public interface StudentEnquiryRepo extends JpaRepository<Student_Enquiry, Integer> {

}
