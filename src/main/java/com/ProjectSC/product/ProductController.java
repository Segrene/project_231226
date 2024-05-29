package com.ProjectSC.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ProjectSC.category.bo.CategoryBO;
import com.ProjectSC.category.domain.Category;
import com.ProjectSC.product.bo.ProductBO;
import com.ProjectSC.product.domain.ProductDetail;
import com.ProjectSC.product.domain.ProductInfo;

@RequestMapping("/product")
@Controller
public class ProductController {
	@Autowired
	private ProductBO productBO;
	@Autowired
	private CategoryBO categoryBO;
	
	@GetMapping({"/category", "/category/{category}"})
	public String productList(@PathVariable(value="category", required = false)Integer category, 
			@RequestParam(value="sub", required = false)Integer sub,
			Model model) {
		if (category == null) {
			category = 0;
		}
		if (sub == null) {
			sub = 0;
		}
		model.addAttribute("viewName", "product/productList");
		List<ProductInfo> productList = productBO.getProductListByCategory(category, sub);
		model.addAttribute("productList", productList);
		model.addAttribute("categoryName", categoryBO.getCategory(category));
		model.addAttribute("subCategoryList", categoryBO.getSubCategoryList(category));
		model.addAttribute("subCategory", categoryBO.getSubCategory(category, sub));
		return "template/layout";
	}
	
	@GetMapping("/productId/{id}")
	public String productDetailView(@PathVariable("id")int id, Model model) {
		model.addAttribute("viewName", "product/productDetail");
		ProductDetail product = productBO.getProductDetailById(id);
		model.addAttribute("product", product);
		return "template/layout";
	}
	
	@GetMapping("/productRegister-view")
	public String productRegisterView(Model model) {
		model.addAttribute("viewName", "product/productRegister");
		List<Category> categoryList = categoryBO.getCategoryList(0);
		model.addAttribute("categoryList", categoryList);
		return "template/layout";
	}
}
