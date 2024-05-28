package com.ProjectSC.product.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ProjectSC.category.mapper.CategoryMapper;
import com.ProjectSC.common.FileManagerService;
import com.ProjectSC.product.domain.ProductDetail;
import com.ProjectSC.product.domain.ProductInfo;
import com.ProjectSC.product.mapper.ProductMapper;

@Service
public class ProductBO {
	
	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private CategoryMapper categoryMapper;
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

	public int addProduct(String name, int sellerId, String sellerName, int price, Integer discount, int finalPrice,
			int category, int subCategory, String delivery, MultipartFile file) {
		String imagePath = null;
		if (file != null) {
			imagePath = FileManager.saveFile(sellerName, file);
		}
		if (imagePath == null) {
			return 0;
		}
		return productMapper.insertProduct(name, sellerId, price, discount, finalPrice, category, subCategory, delivery, imagePath);
	}

	public ProductDetail getProductDetailById(int id) {
		ProductDetail product = new ProductDetail();
		product.setProduct(productMapper.selectProductById(id));
		product.getProduct().setCategoryName(categoryMapper.selectCategory(product.getProduct().getCategory()).getName());
		if (product.getProduct().getSubCategory() != null) {
			product.getProduct().setSubCategoryName(categoryMapper.selectSubCategory(product.getProduct().getCategory(), product.getProduct().getSubCategory()).getName());
		}
		// seller 값 가져오기
		// postList 가져오기
		return product;
	}

	public ProductInfo getProductInfo(int productId) {
		ProductInfo product = productMapper.selectProductInfoByProductId(productId);
		product.setCategoryName(categoryMapper.selectCategory(product.getCategory()).getName());
		if (product.getSubCategory() != null) {
			product.setSubCategoryName(categoryMapper.selectSubCategory(product.getCategory(), product.getSubCategory()).getName());
		}
		return product;
	}

}
