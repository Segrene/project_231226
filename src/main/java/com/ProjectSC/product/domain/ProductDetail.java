package com.ProjectSC.product.domain;

import java.util.List;

import com.ProjectSC.post.domain.PostInfo;
import com.ProjectSC.seller.domain.Seller;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class ProductDetail {
	private Product product;
	private Seller seller;
	private List<PostInfo> postList;
}
