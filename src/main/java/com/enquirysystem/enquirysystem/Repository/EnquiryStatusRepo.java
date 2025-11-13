package com.enquirysystem.enquirysystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enquirysystem.enquirysystem.Entity.Enquiry_Status;

@Repository
public interface EnquiryStatusRepo extends JpaRepository<Enquiry_Status, Integer>{

}
