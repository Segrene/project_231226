package com.ProjectSC.cart.domain;

import com.ProjectSC.product.domain.ProductInfo;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class CartView {
	private Cart cart;
	private ProductInfo productInfo;
}
