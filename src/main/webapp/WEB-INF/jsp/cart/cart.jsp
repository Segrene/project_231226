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
			<div>
				<h1>장바구니</h1>
			</div>
			<div class="cart-form bg-light d-flex justify-content-center">
				<div class="border" id="cartItems">
					<c:forEach items="${cart}" var="cart" varStatus="status">
						<div class="CartBox  d-flex justify-content-around bg-warning border-dark rounded m-3">
							<div class="d-flex CartThumbnail align-items-center justify-content-center"
							onclick="location.href='/product/productId/${cart.productInfo.id}';" style="cursor: pointer;">
								<img src="${cart.productInfo.imagePath}" class="rounded-lg" width="120px" height="120px">
							</div>
							<div class="d-flex align-items-center mb-2">
								<div>
									<div class="ml-3 mb-2 PName">${cart.productInfo.name}</div>
									<div class="ml-3 mb-2 PName">${cart.cart.qty}개</div>
									<fmt:formatNumber var="priceOrigin" value="${cart.productInfo.price * cart.cart.qty}" type="currency" currencySymbol="￦" maxFractionDigits="0" />
									<div class="ml-3 PPrice">
										<del>${priceOrigin}</del>
									</div>
									<fmt:formatNumber var="priceResult" value="${cart.productInfo.finalPrice * cart.cart.qty}"
									type="currency" currencySymbol="￦" maxFractionDigits="0"/>
									<div class="ml-3 PPriceDiscount">${priceResult}</div>
									<div class="ml-3 mb-2">${cart.productInfo.deliveryType}</div>
								</div>
								<fmt:formatNumber var="DCPercent" value="${cart.productInfo.discount / 100}" type="percent" maxFractionDigits="0" />
								<div class="mx-2 PDiscount">-${DCPercent}</div>
							</div>
							<button type="button" class="btn btn-danger deleteBtn" data-product="${cart.cart.productId}">X</button>
						</div>
					</c:forEach>
				</div>
				<div class="border font-weight-light p-5" id="cartTotal">
					<div class="d-flex aling-items-center">
						<div>전체 가격 : </div>
						<div class="cartProductPrice ml-1"></div>
					</div>
					<div class="d-flex aling-items-center">
						<div>전체 배송료 : </div>
						<div class="cartDeliveryFee ml-1"></div>
					</div>
					<div>
						<button type="button" class="btn btn-primary buyBtn">구매하기</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script>
$(document).ready(function() {
	let productPrice = 0;
	<c:forEach items="${cart}" var="cart">
		productPrice += ${cart.productInfo.finalPrice * cart.cart.qty};
	</c:forEach>
	console.log(productPrice);
	$('.cartProductPrice').text(productPrice);
	
	let deliveryFee = 0;
	<c:forEach items="${cart}" var="cart">
		if (${cart.productInfo.deliveryType == "당일 배송"}) {
			deliveryFee += 3500 * ${cart.cart.qty};
		} else if (${cart.productInfo.deliveryType == "즉시 배송"}) {
			deliveryFee += 3000 * ${cart.cart.qty};
		} else if (${cart.productInfo.deliveryType == "일반 배송"}) {
			deliveryFee += 1000 * ${cart.cart.qty};
		} else if (${cart.productInfo.deliveryType == "자체 배송"}) {
			deliveryFee += 0 * ${cart.cart.qty};
		}
	</c:forEach>
	console.log(deliveryFee);
	$('.cartDeliveryFee').text(deliveryFee);
	$('.deleteBtn').on('click', function(e) {
		alert("삭제");
	});
	$('.buyBtn').on('click', function(e) {
		alert("구매");
	});
});
</script>
</html>