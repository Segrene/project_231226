package com.ProjectSC.cart;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ProjectSC.cart.bo.CartBO;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/cart")
@RestController
public class CartRestController {
	
	@Autowired
	private CartBO cartBO;
	
	@PostMapping("/addToCart")
	public Map<String, Object> addToCart(@RequestParam("productId")int productId,
			@RequestParam("qty")int qty, HttpSession session) {
		Map<String, Object> result = new HashMap<>();
		Integer userId = (Integer)session.getAttribute("userId");
		if (userId == null) {
			result.put("code", 500);
			result.put("error_message", "로그인 정보 만료");
			return result;
		}
		int rowCount = cartBO.addProduct(userId, productId, qty);
		if (rowCount == 0) {
			result.put("code", 500);
			result.put("error_message", "DB 에러");
			return result;
		}
		result.put("code", 200);
		result.put("result", "성공");
		return result;
	}
}
