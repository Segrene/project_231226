package com.ProjectSC.pay;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/pay")
@Controller
public class PayController {
	@GetMapping("/payment")
	public String Payment() {
		return "pay/payment";
	}
}
