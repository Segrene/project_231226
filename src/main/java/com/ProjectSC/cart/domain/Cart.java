package com.ProjectSC.cart.domain;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Cart {
	private int userId;
	private int productId;
	private int qty;
	private Date createdAt;
	private Date updatedAt;
}
