package com.ProjectSC.product.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ProjectSC.product.domain.Product;
import com.ProjectSC.product.domain.ProductInfo;

@Mapper
public interface ProductMapper {

	List<ProductInfo> selectAllProductList();

	List<ProductInfo> selectProductListByCategory(int category);

	List<ProductInfo> selectProductListByCategoryAndSubCategory(@Param("category")int category, @Param("subCategory")Integer subCategory);

	int insertProduct(@Param("name")String name, @Param("sellerId")Integer sellerId, @Param("price")int price, 
			@Param("discount")int discount, @Param("category")int category, @Param("subCategory")int subCategory,
			@Param("deliveryType")String deliveryType, @Param("imagePath")String imagePath);

	Product selectProductById(int id);

	ProductInfo selectProductInfoByProductId(int productId);

}
