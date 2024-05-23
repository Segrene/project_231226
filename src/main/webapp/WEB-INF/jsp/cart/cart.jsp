<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="/static/css/style.css">
<title>ProjectSC</title>
</head>
<body>
	<div class="container d-flex justify-content-center p-0">
		<div id="wrap">
			<div class="cart-form bg-light d-flex justify-content-center">
				<div class="border" id="cartItems">
					<c:forEach items="${cart}" var="cart" varStatus="status">
						<div class="PBox bg-warning border-dark rounded m-3"
							onclick="location.href='/product/productId/${product.id}';" style="cursor: pointer;">
							<div
								class="d-flex PThumbnail align-items-center justify-content-center">
								<img src="${cart.imagePath}" class="rounded-lg" width="100px" height="100px">
							</div>
							<div class="ml-3 mb-2 PName">${product.name}</div>
							<div class="d-flex align-items-center mb-2">
								<div>
									<fmt:formatNumber var="priceOrigin" value="${product.price}" type="currency" currencySymbol="￦" maxFractionDigits="0" />
									<div class="ml-3 PPrice">
										<del>${priceOrigin}</del>
									</div>
									<fmt:formatNumber var="priceResult" value="${product.price - (product.price * product.discount / 100)}" type="currency" currencySymbol="￦" maxFractionDigits="0" />
									<div class="ml-3 PPriceDiscount">${priceResult}</div>
								</div>
								<fmt:formatNumber var="DCPercent" value="${product.discount / 100}" type="percent" maxFractionDigits="0" />
								<div class="ml-2 PDiscount">-${DCPercent}</div>
							</div>
							<div class="ml-3 mb-2">${product.deliveryType}</div>
						</div>
					</c:forEach>
				</div>
				<div class="border" id="cartTotal"></div>
			</div>
		</div>
	</div>
</body>
</html>