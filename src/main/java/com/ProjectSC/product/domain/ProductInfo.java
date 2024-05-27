package com.ProjectSC.product.domain;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class ProductInfo {
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
}
