package com.facultyavailability.faculty_availability.entity;
import jakarta.persistence.*; import java.time.*;
@Entity @Table(name="faculty_availability") public class FacultyAvailability {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) private AppUser faculty;
 @Column(nullable=false) private LocalDate date;
 @Column(nullable=false) private LocalTime startTime;
 @Column(nullable=false) private LocalTime endTime;
 private String location; private String note; private boolean active=true;
 public Long getId(){return id;} public AppUser getFaculty(){return faculty;} public void setFaculty(AppUser v){faculty=v;} public LocalDate getDate(){return date;} public void setDate(LocalDate v){date=v;} public LocalTime getStartTime(){return startTime;} public void setStartTime(LocalTime v){startTime=v;} public LocalTime getEndTime(){return endTime;} public void setEndTime(LocalTime v){endTime=v;} public String getLocation(){return location;} public void setLocation(String v){location=v;} public String getNote(){return note;} public void setNote(String v){note=v;} public boolean isActive(){return active;} public void setActive(boolean v){active=v;}
}
