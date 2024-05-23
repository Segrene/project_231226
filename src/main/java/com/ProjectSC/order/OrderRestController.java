package com.ProjectSC.order;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ProjectSC.order.bo.OrderBO;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/order")
@RestController
public class OrderRestController {
	
	@Autowired
	private OrderBO orderBO;
	
//	@PostMapping("/directOrder")
//	public Map<String, Object> addOrderProduct(@RequestParam("productId")int productId,
//			@RequestParam("qty")int qty, HttpSession session) {
//		Map<String, Object> result = new HashMap<>();
//		Integer userId = (Integer)session.getAttribute("userId");
//		result.put("code", 200);
//		result.put("result", "성공");
//		return result;
//	}
}
