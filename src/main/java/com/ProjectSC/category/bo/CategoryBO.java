package com.ProjectSC.category.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjectSC.category.domain.Category;
import com.ProjectSC.category.domain.SubCategory;
import com.ProjectSC.category.mapper.CategoryMapper;

@Service
public class CategoryBO {
	
	@Autowired
	private CategoryMapper categoryMapper;
	
	public List<Category> getCategoryList(int type) {
		return categoryMapper.selectCategoryList(type);
	}
	
	public Category getCategory(int id) {
		return categoryMapper.selectCategory(id);
	}
	
	public List<SubCategory> getSubCategoryList(int category) {
		return categoryMapper.selectSubCategoryList(category);
	}
	
	public SubCategory getSubCategory(int category, Integer id) {
		return categoryMapper.selectSubCategory(category, id);
	}
}
