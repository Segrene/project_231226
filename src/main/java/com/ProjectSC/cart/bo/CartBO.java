package com.ProjectSC.cart.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjectSC.cart.domain.Cart;
import com.ProjectSC.cart.domain.CartView;
import com.ProjectSC.cart.mapper.CartMapper;
import com.ProjectSC.product.bo.ProductBO;

@Service
public class CartBO {
	
	@Autowired
	private CartMapper cartMapper;
	@Autowired
	private ProductBO productBO;

	public int addProduct(int userId, int productId, int qty) {
		int rowCount;
		Cart cart = cartMapper.selectCartProduct(userId, productId);
		if (cart != null) {
			cart.setQty(cart.getQty() + qty);
			rowCount = cartMapper.updateProduct(cart);
		} else {
			rowCount = cartMapper.insertProduct(userId, productId, qty);
		}
		return rowCount;
	}

	public List<CartView> getCartList(int userId) {
		List<CartView> cartViewList = new ArrayList<>();
		List<Cart> cartList = cartMapper.selectCartList(userId);
		for (Cart cart : cartList) {
			CartView cartView = new CartView();
			cartView.setCart(cart);
			cartView.setProductInfo(productBO.getProductInfo(cart.getProductId()));
			cartViewList.add(cartView);
		}
		return cartViewList;
	}

	public int deleteProduct(int userId, int productId) {
		return cartMapper.deleteProduct(userId, productId);
	}

}
