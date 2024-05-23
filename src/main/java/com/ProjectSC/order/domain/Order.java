package com.ProjectSC.order.domain;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Order {
	private int id;
	private int userId;
	private String receiver;
	private String contact;
	private String address;
	private String status;
	private String paymentMethod;
	private int amount;
	private int deliveryPrice;
	private int totalAmount;
	private Date estimated;
	private Date delivered;
	private Date createdAt;
	private Date updatedAt;
}
