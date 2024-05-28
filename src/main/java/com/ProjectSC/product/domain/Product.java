package com.ProjectSC.product.domain;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Product {
	private int id;
	private int sellerId;
	private int category;
	private Integer subCategory;
	private String name;
	private int price;
	private int discount;
	private int finalPrice;
	private String deliveryType;
	private String imagePath;
	private String content;
	private Date createdAt;
	private Date updatedAt;
	private String categoryName;
	private String subCategoryName;
}
