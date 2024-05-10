package com.ProjectSC.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/test")
@Controller
public class TestController {
	@GetMapping("/test")
	public String test() {
		return "test/test";
	}
}
