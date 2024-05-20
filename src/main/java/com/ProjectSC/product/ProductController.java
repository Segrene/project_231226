package com.ProjectSC.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ProjectSC.product.bo.ProductBO;
import com.ProjectSC.product.domain.ProductInfo;

@RequestMapping("/product")
@Controller
public class ProductController {
	@Autowired
	private ProductBO productBO;
	
	@GetMapping({"/category", "/category/{category}"})
	public String productList(@PathVariable(value="category", required = false)Integer category, 
			@RequestParam(value="sub", required = false)Integer sub,
			Model model) {
		if (category == null) {
			category = 0;
		}
		model.addAttribute("viewName", "product/productList");
		List<ProductInfo> productList = productBO.getProductListByCategory(category, sub);
		model.addAttribute("productList", productList);
		return "template/layout";
	}
	
	@GetMapping("/productRegister")
	public String productRegister(Model model) {
		model.addAttribute("viewName", "product/productRegister");
		return "template/layout";
	}
}
