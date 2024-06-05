package com.ProjectSC.order.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjectSC.cart.bo.CartBO;
import com.ProjectSC.cart.domain.CartView;
import com.ProjectSC.order.domain.Order;

@Service
public class OrderBO {
	
	@Autowired
	private CartBO cartBO;
	
	public Order orderPrepare(int userId) {
		Order order = new Order();
		int totalAmount = 0;
		int deliveryFee = 0;
		List<CartView> cartItems = cartBO.getCartList(userId);
		for (CartView cart : cartItems) {
			totalAmount += cart.getProductInfo().getFinalPrice() * cart.getCart().getQty();
			if (cart.getProductInfo().getDeliveryType().equals("당일 배송")) {
				deliveryFee += 3500 * cart.getCart().getQty();
			} else if (cart.getProductInfo().getDeliveryType().equals("즉시 배송")) {
				deliveryFee += 3000 * cart.getCart().getQty();
			} else if (cart.getProductInfo().getDeliveryType().equals("일반 배송")) {
				deliveryFee += 1000 * cart.getCart().getQty();
			}
		}
		order.setUserId(userId);
		order.setAmount(totalAmount);
		order.setDeliveryFee(deliveryFee);
		order.setTotalAmount(totalAmount + deliveryFee);
		return order;
	}
	
	public Order orderCompletion(Order order) {
		return order;
	}
}
