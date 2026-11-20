package com.facultyavailability.faculty_availability.repository;
import org.springframework.data.jpa.repository.JpaRepository; import com.facultyavailability.faculty_availability.entity.Appointment; import java.util.*;
public interface AppointmentRepository extends JpaRepository<Appointment,Long>{ List<Appointment> findByStudentIdOrderByCreatedAtDesc(Long id); List<Appointment> findByFacultyIdOrderByCreatedAtDesc(Long id); }
