package com.ProjectSC.category;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ProjectSC.category.bo.CategoryBO;
import com.ProjectSC.category.domain.Category;
import com.ProjectSC.category.domain.SubCategory;

@RequestMapping("/category")
@RestController
public class CategoryRestController {
	
	@Autowired
	private CategoryBO categoryBO;
	
	@GetMapping("getCategoryList")
	public Map<String, Object> getCategoryList(@RequestParam("type")int type, Model model) {
		Map<String, Object> result = new HashMap<>();
		List<Category> categoryList = categoryBO.getCategoryList(type);
		model.addAttribute("categoryList", categoryList);
		result.put("code", 200);
		result.put("result", "성공");
		return result;
	}
}
