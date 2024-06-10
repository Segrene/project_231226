package com.ProjectSC.pay;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProjectSC.order.bo.OrderBO;
import com.ProjectSC.pay.bo.PaymentBO;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/payment")
@RestController
public class PayRestController {
	
	@Autowired
	private PaymentBO paymentBO;
	@Autowired
	private OrderBO orderBO;
	
	@PostMapping("/complete")
	public Map<String, Object> payComplete(@RequestBody HashMap<String, Object> Map, 
			HttpSession session) {
		String paymentId = Map.get("paymentId").toString();
		int orderId = Integer.parseInt(Map.get("orderId").toString());
		String address = Map.get("address").toString();
		int paymentMethod = Integer.parseInt(Map.get("paymentMethod").toString());
		Map<String, Object> result = new HashMap<>();
		result = paymentBO.paymentCompletion(paymentId, orderId);
		if (Integer.parseInt(result.get("code").toString()) == 200) {
			String receiver = "tester1";
			String contact = "None";
			orderBO.addOrder(orderId, address, paymentMethod, receiver, contact, paymentId);
		}
		return result;
	}
	
	@GetMapping("/completeDebug")
	public Map<String, Object> payCompleteDebug() {
		String paymentId = "5cff75df-71b8-4122-b106-e276d7a4991f";
		Map<String, Object> payment = paymentBO.paymentCompletionDebug(paymentId);
		return payment;
	}
}
