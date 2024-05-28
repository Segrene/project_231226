package com.ProjectSC.category.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ProjectSC.category.domain.Category;
import com.ProjectSC.category.domain.SubCategory;

@Mapper
public interface CategoryMapper {

	List<Category> selectCategoryList(int type);

	Category selectCategory(int id);
	
	List<SubCategory> selectSubCategoryList(int category);

	SubCategory selectSubCategory(@Param("category")int category, @Param("id")Integer id);
	
}
