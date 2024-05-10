package com.ProjectSC.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/ProjectSC")
@Controller
public class MainController {
	@GetMapping("/main")
	public String main() {
		return "main/main";
	}
}
