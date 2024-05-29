<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="bg-dark" id="productList">
	<div class="bg-light d-flex" id="productCategory">
		<div class="m-3 font-weight-bolder" id="PListCategory">${categoryName.name}</div>
		<div class="m-3 font-weight-lighter" id="PListSubCategory">${subCategory.name}</div>
	</div>
	<div class="bg-light font-weight-light" id="productSubCategory">
	<ul class="nav nav-pills">
		<c:forEach items="${subCategoryList}" var="subCategory">
			<li class="nav-item"><a class="nav-link"
			href="/product/category/${categoryName.id}?sub=${subCategory.id}">${subCategory.name}</a></li>
		</c:forEach>
	</ul>
	</div>
	<div class="d-flex flex-wrap justify-content-around">
		<c:forEach items="${productList}" var="product" varStatus="status">
		<div class="PBox bg-warning border-dark rounded m-3"
		 onclick="location.href='/product/productId/${product.id}';" style=" cursor: pointer;">
			<div class="d-flex PThumbnail align-items-center justify-content-center">		
				<img src="${product.imagePath}" class="rounded" width="200px" height="200px">
			</div>
			<div class="ml-3 mb-2 PName">${product.name}</div>
			<div class="d-flex align-items-center mb-2">
				<div>
					<fmt:formatNumber var="priceOrigin" value="${product.price}"
					 type="currency" currencySymbol="￦" maxFractionDigits="0"/>
					<div class="ml-3 PPrice"><del>${priceOrigin}</del></div>
					<fmt:formatNumber var="priceResult" value="${product.finalPrice}"
					 type="currency" currencySymbol="￦" maxFractionDigits="0"/>
					<div class="ml-3 PPriceDiscount">${priceResult}</div>
				</div>
				<fmt:formatNumber var="DCPercent" value="${product.discount / 100}"
					 type="percent" maxFractionDigits="0"/>
				<div class="ml-2 PDiscount">-${DCPercent}</div>
			</div>
			<div class="ml-3 mb-2">${product.deliveryType}</div>
		</div>
		</c:forEach>
	</div>
</div>