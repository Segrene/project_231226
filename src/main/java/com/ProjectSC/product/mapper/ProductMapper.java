package com.ProjectSC.product.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ProjectSC.product.domain.ProductInfo;

@Mapper
public interface ProductMapper {

	List<ProductInfo> selectAllProductList();

	List<ProductInfo> selectProductListByCategory(int category);

	List<ProductInfo> selectProductListByCategoryAndSubCategory(@Param("category")int category, @Param("subCategory")Integer subCategory);

}
