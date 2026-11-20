package com.facultyavailability.faculty_availability.controller;
import org.springframework.stereotype.Controller; import org.springframework.ui.Model; import org.springframework.web.bind.annotation.*; import jakarta.servlet.http.HttpSession; import com.facultyavailability.faculty_availability.entity.AppUser; import com.facultyavailability.faculty_availability.service.AppUserService;
@Controller public class AuthController {
 private final AppUserService users; public AuthController(AppUserService u){users=u;}
 @GetMapping("/register") public String reg(Model m){m.addAttribute("user",new AppUser());return "register";}
 @PostMapping("/register") public String register(@ModelAttribute AppUser user,Model m){try{users.register(user);return "redirect:/login?registered";}catch(Exception e){m.addAttribute("user",user);m.addAttribute("error",e.getMessage());return "register";}}
 @GetMapping("/login") public String login(){return "login";}
 @PostMapping("/login") public String doLogin(@RequestParam String email,@RequestParam String password,HttpSession s,Model m){AppUser u=users.login(email,password);if(u==null){m.addAttribute("error","Email or password is incorrect.");return "login";}s.setAttribute("userId",u.getId());s.setAttribute("userName",u.getName());s.setAttribute("role",u.getRole());return "redirect:/dashboard";}
 @GetMapping("/dashboard") public String dashboard(HttpSession s){if(s.getAttribute("userId")==null)return "redirect:/login";return switch((String)s.getAttribute("role")){case "FACULTY"->"redirect:/faculty/dashboard";case "ADMIN"->"redirect:/admin/dashboard";default->"redirect:/student/dashboard";};}
 @GetMapping("/logout") public String logout(HttpSession s){s.invalidate();return "redirect:/?logout";}
}
