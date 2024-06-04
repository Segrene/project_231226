package com.ProjectSC.pay;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ProjectSC.pay.bo.PaymentBO;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/payment")
@RestController
public class PayRestController {
	
	@Autowired
	private PaymentBO paymentBO;
	
	@PostMapping("/complete")
	public Map<String, Object> payComplete(@RequestParam("paymentId")String paymentId, HttpSession session) {
		Map<String, Object> result = new HashMap<>();
		paymentBO.paymentCompletion(paymentId);
		return result;
	}
}
