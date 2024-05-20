package com.ProjectSC.product.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjectSC.product.domain.ProductInfo;
import com.ProjectSC.product.mapper.ProductMapper;

@Service
public class ProductBO {
	
	@Autowired
	private ProductMapper productMapper;

	public List<ProductInfo> getProductListByCategory(int category, Integer subCategory) {
		if (category == 0) {
			return productMapper.selectAllProductList();
		}
		if (subCategory == null) {
			return productMapper.selectProductListByCategory(category);
		}
		return productMapper.selectProductListByCategoryAndSubCategory(category, subCategory);
	}

}
