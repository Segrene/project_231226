package com.ProjectSC.pay;

import java.util.HashMap;
import java.util.Map;

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
		int preOrderId = Integer.parseInt(Map.get("orderId").toString());
		String address = Map.get("address").toString();
		String receiver = Map.get("receiver").toString();
		String contact = Map.get("contact").toString();
		int paymentMethod = Integer.parseInt(Map.get("paymentMethod").toString());
		Map<String, Object> result = new HashMap<>();
		result = paymentBO.paymentCompletion(paymentId, preOrderId);
		if (Integer.parseInt(result.get("code").toString()) == 200) {
			int orderId = orderBO.addOrder(preOrderId, address, paymentMethod, receiver, contact, paymentId);
			result.put("orderId", orderId);
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
