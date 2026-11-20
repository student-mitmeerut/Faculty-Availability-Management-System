package com.facultyavailability.faculty_availability.repository;
import org.springframework.data.jpa.repository.JpaRepository; import com.facultyavailability.faculty_availability.entity.*; import java.util.*;
public interface FacultyAvailabilityRepository extends JpaRepository<FacultyAvailability,Long>{ List<FacultyAvailability> findByActiveTrueOrderByDateAscStartTimeAsc(); List<FacultyAvailability> findByFacultyIdOrderByDateAscStartTimeAsc(Long id); }
