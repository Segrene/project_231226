package com.ProjectSC.order.domain;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class OrderProduct {
	private int orderId;
	private int productId;
	private int qty;
}
