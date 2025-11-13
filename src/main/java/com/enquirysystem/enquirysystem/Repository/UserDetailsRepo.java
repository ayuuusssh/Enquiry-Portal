package com.enquirysystem.enquirysystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enquirysystem.enquirysystem.Entity.User_Details;

@Repository
public interface UserDetailsRepo extends JpaRepository<User_Details, Integer> {

}
