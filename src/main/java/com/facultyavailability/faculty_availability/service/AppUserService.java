package com.facultyavailability.faculty_availability.service;
import org.springframework.stereotype.Service; import org.springframework.security.crypto.password.PasswordEncoder; import com.facultyavailability.faculty_availability.entity.AppUser; import com.facultyavailability.faculty_availability.repository.AppUserRepository;
@Service public class AppUserService {
 private final AppUserRepository repo; private final PasswordEncoder encoder;
 public AppUserService(AppUserRepository r,PasswordEncoder e){repo=r;encoder=e;}
 public AppUser register(AppUser u){u.setName(u.getName().trim());u.setEmail(u.getEmail().trim().toLowerCase());if(repo.existsByEmailIgnoreCase(u.getEmail()))throw new IllegalArgumentException("This email is already registered.");if(!u.getRole().equals("STUDENT")&&!u.getRole().equals("FACULTY"))throw new IllegalArgumentException("Choose Student or Faculty.");if(u.getPassword().length()<8)throw new IllegalArgumentException("Password must be at least 8 characters.");u.setPassword(encoder.encode(u.getPassword()));return repo.save(u);}
 public AppUser login(String email,String password){AppUser u=repo.findByEmailIgnoreCase(email.trim()).orElse(null);return u!=null&&encoder.matches(password,u.getPassword())?u:null;}
}
