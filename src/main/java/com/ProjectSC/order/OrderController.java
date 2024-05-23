package com.ProjectSC.order;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/order")
@Controller
public class OrderController {
	@GetMapping("/order-view")
	public String orderView(Model model) {
		model.addAttribute("viewName", "order/order");
		return "template/layout";
	}
}
