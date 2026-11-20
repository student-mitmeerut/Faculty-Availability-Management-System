package com.facultyavailability.faculty_availability.entity;
import jakarta.persistence.*; import java.time.*;
@Entity @Table(name="appointments") public class Appointment {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) private AppUser student;
 @ManyToOne(optional=false) private AppUser faculty;
 @ManyToOne(optional=false) private FacultyAvailability availability;
 @Column(length=1000) private String purpose;
 @Column(nullable=false) private String status="PENDING";
 @Column(nullable=false) private LocalDateTime createdAt=LocalDateTime.now();
 public Long getId(){return id;} public AppUser getStudent(){return student;} public void setStudent(AppUser v){student=v;} public AppUser getFaculty(){return faculty;} public void setFaculty(AppUser v){faculty=v;} public FacultyAvailability getAvailability(){return availability;} public void setAvailability(FacultyAvailability v){availability=v;} public String getPurpose(){return purpose;} public void setPurpose(String v){purpose=v;} public String getStatus(){return status;} public void setStatus(String v){status=v;} public LocalDateTime getCreatedAt(){return createdAt;}
}
