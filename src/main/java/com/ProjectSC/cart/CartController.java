package com.ProjectSC.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ProjectSC.cart.bo.CartBO;
import com.ProjectSC.cart.domain.CartView;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/cart")
@Controller
public class CartController {
	
	@Autowired
	private CartBO cartBO;
	
	@GetMapping("cart-view")
	public String cartView(HttpSession session, Model model) {
		Integer userId = (Integer)session.getAttribute("userId");
		List<CartView> cartList = cartBO.getCartList(userId);
		model.addAttribute("cart", cartList);
		return "cart/cart";
	}
}
