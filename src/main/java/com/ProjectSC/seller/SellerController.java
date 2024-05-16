package com.ProjectSC.seller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/seller")
@Controller
public class SellerController {
	@GetMapping("/login-view")
	public String sellerLoginView() {
		return "seller/login";
	}
	
	@GetMapping("/sign-up-view")
	public String sellerSignUpView() {
		return "seller/signUp";
	}
}
