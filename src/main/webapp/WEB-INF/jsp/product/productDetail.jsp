<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="d-flex">
	<div id="PRImage">
		<img id="thumbnail" src="${product.product.imagePath}" width="600px" height="600px">
	</div>
	<div id="PROption" class="bg-light border rounded-lg">
		<div>
			<div class="m-3">${product.product.name}</div>
			<hr>
			<div class="d-flex">
			<div>
				<fmt:formatNumber var="priceOrigin" value="${product.product.price}"
					type="currency" currencySymbol="￦" maxFractionDigits="0" />
				<div class="ml-3 PPrice">
					<del>${priceOrigin}</del>
				</div>
				<fmt:formatNumber var="priceResult"
					value="${product.product.price - (product.product.price * product.product.discount / 100)}"
					type="currency" currencySymbol="￦" maxFractionDigits="0" />
				<div class="ml-3 PPriceDiscount">${priceResult}</div>
			</div>
			<fmt:formatNumber var="DCPercent" value="${product.product.discount / 100}"
				type="percent" maxFractionDigits="0" />
			<div class="ml-2 PDiscount">-${DCPercent}</div>
			</div>
			<hr>
			<div class="m-3">${product.product.category}</div>
	  		<div class="m-3">${product.product.subCategory}</div>
			<hr>
			<div class="m-3">${product.product.deliveryType}</div>
		</div>
	</div>
</div>
<div>
	<div class="border rounded-lg p-2" id="editor">
		${product.product.content}
	</div>
</div>