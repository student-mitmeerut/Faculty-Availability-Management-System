package com.facultyavailability.faculty_availability.entity;
import jakarta.persistence.*;
@Entity @Table(name="app_users") public class AppUser {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false) private String name;
 @Column(unique=true,nullable=false) private String email;
 @Column(nullable=false) private String password;
 @Column(nullable=false) private String role;
 public Long getId(){return id;} public void setId(Long v){id=v;} public String getName(){return name;} public void setName(String v){name=v;} public String getEmail(){return email;} public void setEmail(String v){email=v;} public String getPassword(){return password;} public void setPassword(String v){password=v;} public String getRole(){return role;} public void setRole(String v){role=v;}
}
