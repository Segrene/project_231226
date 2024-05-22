package com.ProjectSC.product.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ProjectSC.common.FileManagerService;
import com.ProjectSC.product.domain.ProductDetail;
import com.ProjectSC.product.domain.ProductInfo;
import com.ProjectSC.product.mapper.ProductMapper;

@Service
public class ProductBO {
	
	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private FileManagerService FileManager;

	public List<ProductInfo> getProductListByCategory(int category, Integer subCategory) {
		if (category == 0) {
			return productMapper.selectAllProductList();
		}
		if (subCategory == null) {
			return productMapper.selectProductListByCategory(category);
		}
		return productMapper.selectProductListByCategoryAndSubCategory(category, subCategory);
	}

	public int addProduct(String name, Integer sellerId, String sellerName, int price, int discount, int category, int subCategory,
			String delivery, MultipartFile file, String content) {
		String imagePath = null;
		if (file != null) {
			imagePath = FileManager.saveFile(sellerName, file);
		}
		if (imagePath == null) {
			return 0;
		}
		return productMapper.insertProduct(name, sellerId, price, discount, category, subCategory, delivery, imagePath, content);
	}

	public ProductDetail getProductDetailById(int id) {
		ProductDetail product = new ProductDetail();
		product.setProduct(productMapper.selectProductById(id));
		// seller 값 가져오기
		// postList 가져오기
		return product;
	}

}
