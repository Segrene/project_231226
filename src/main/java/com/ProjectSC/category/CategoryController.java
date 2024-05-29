package com.ProjectSC.category;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ProjectSC.category.bo.CategoryBO;
import com.ProjectSC.category.domain.SubCategory;

@RequestMapping("/category")
@Controller
public class CategoryController {
	
	@Autowired
	private CategoryBO categoryBO;
	
	@GetMapping("getSubCategoryList")
	public String getSubCategoryList(@RequestParam("category")int category, Model model) {
		List<SubCategory> subCategoryList = categoryBO.getSubCategoryList(category);
		model.addAttribute("subCategoryList", subCategoryList);
		return "product/productSubCategoryList";
	}
}
