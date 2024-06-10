package com.ProjectSC.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ProjectSC.order.bo.OrderBO;
import com.ProjectSC.order.domain.Order;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/order")
@Controller
public class OrderController {
	
	@Autowired
	private OrderBO orderBO;
	
	@GetMapping("/order-view")
	public String orderView(Model model, HttpSession session) {
		Integer userId = (Integer)session.getAttribute("userId");
		if (userId == null) {
			return "user/login";
		}
		Order order = orderBO.orderPrepare(userId);
		model.addAttribute("order", order);
		return "order/order";
	}
	
	@GetMapping("/result")
	public String orderResult(Model model, HttpSession session) {
		Integer userId = (Integer)session.getAttribute("userId");
		if (userId == null) {
			return "user/login";
		}
		return "order/orderResult";
	}
}
