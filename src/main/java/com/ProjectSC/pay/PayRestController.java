package com.ProjectSC.pay;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
		result = paymentBO.paymentCompletion(paymentId);
		return result;
	}
	
	@GetMapping("/completeDebug")
	public Map<String, Object> payCompleteDebug() {
		String paymentId = "payment-c85d4449-d143-4116-aa23-dbd726a91c7d";
		Map<String, Object> payment = paymentBO.paymentCompletionDebug(paymentId);
		return payment;
	}
}
