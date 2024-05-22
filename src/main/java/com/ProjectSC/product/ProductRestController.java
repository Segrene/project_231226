package com.ProjectSC.product;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ProjectSC.product.bo.ProductBO;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/product")
@RestController
public class ProductRestController {
	
	@Autowired
	private ProductBO productBO;
	
	@PostMapping("/register")
	public Map<String, Object> productRegister(
			@RequestParam("name")String name,
			@RequestParam("price")int price,
			@RequestParam("discount")int discount,
			@RequestParam("category")int category,
			@RequestParam("subCategory")int subCategory,
			@RequestParam("delivery")String delivery,
			@RequestParam("file") MultipartFile file,
			@RequestParam(value = "content", required = false)String content, //분리 예정
			HttpSession session) {
		Map<String, Object> result = new HashMap<>();
		Integer sellerId = (Integer)session.getAttribute("userId");
		if (sellerId == null) {
			result.put("code", 500);
			result.put("error_message", "로그인 정보 만료");
			return result;
		}
		String sellerName = (String)session.getAttribute("userLoginId");
		int rowCount = productBO.addProduct(name, sellerId, sellerName, price, discount, category, subCategory, delivery, file, content);
		if (rowCount == 0) {
			result.put("code", 500);
			result.put("error_message", "DB 오류");
			return result;
		}
		result.put("code", 200);
		result.put("result", "성공");
		return result;
	}
}
