package com.facultyavailability.faculty_availability.repository;
import org.springframework.data.jpa.repository.JpaRepository; import com.facultyavailability.faculty_availability.entity.AppUser; import java.util.*;
public interface AppUserRepository extends JpaRepository<AppUser,Long>{ Optional<AppUser> findByEmailIgnoreCase(String email); boolean existsByEmailIgnoreCase(String email); List<AppUser> findByRole(String role); }
