package com.ProjectSC.cart.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ProjectSC.cart.domain.Cart;

@Mapper
public interface CartMapper {
	int insertProduct(@Param("userId")int userId, @Param("productId")int productId, @Param("qty")int qty);

	List<Cart> selectCartList(int userId);

	Cart selectCartProduct(@Param("userId")int userId, @Param("productId")int productId);

	int updateProduct(Cart cart);
}