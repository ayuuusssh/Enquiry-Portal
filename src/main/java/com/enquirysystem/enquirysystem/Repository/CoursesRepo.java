package com.enquirysystem.enquirysystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enquirysystem.enquirysystem.Entity.Courses;

@Repository
public interface CoursesRepo extends JpaRepository<Courses, Integer> {

}
