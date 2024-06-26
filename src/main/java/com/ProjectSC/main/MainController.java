package com.ProjectSC.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/main")
@Controller
public class MainController {
	@GetMapping("/main")
	public String main(Model model) {
		model.addAttribute("viewName", "main/main");
		model.addAttribute("productCategory", "null");
		return "template/layout";
	}
}
