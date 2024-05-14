package com.ProjectSC.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/user")
@Controller
public class UserController {
	
	@GetMapping("/login-view")
	public String loginView() {
		return "user/login";
	}
	
	@GetMapping("/sign-up-view")
	public String signUpView() {
		return "user/signUp";
	}
	
	@RequestMapping("/logout")
	public String signOut(HttpSession session) {
		session.removeAttribute("userId");
		session.removeAttribute("userLoginId");
		session.removeAttribute("userEmail");
		return "redirect:/main/main";
	}
}
