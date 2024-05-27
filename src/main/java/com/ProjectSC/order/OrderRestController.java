package com.ProjectSC.order;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProjectSC.cart.bo.CartBO;
import com.ProjectSC.order.bo.OrderBO;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/order")
@RestController
public class OrderRestController {
	
	@Autowired
	private OrderBO orderBO;
	@Autowired
	private CartBO cartBO;
	
//	@PostMapping("/directOrder")
//	public Map<String, Object> addOrderProduct(@RequestParam("productId")int productId,
//			@RequestParam("qty")int qty, HttpSession session) {
//		Map<String, Object> result = new HashMap<>();
//		Integer userId = (Integer)session.getAttribute("userId");
//		result.put("code", 200);
//		result.put("result", "성공");
//		return result;
//	}
	
	@GetMapping("/cartOrder")
	public Map<String, Object> cartOrder(HttpSession session, Model model) {
		Map<String, Object> result = new HashMap<>();
		return result;
	}
}
