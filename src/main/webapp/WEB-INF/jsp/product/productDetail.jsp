<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<input type="hidden" id="productId" value="${product.product.id}">
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
			<hr>
			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<label class="input-group-text" for="productCount">구매 수량</label>
				</div>
				<select class="custom-select" id="productCount">
					<option selected value="1">1</option>
					<c:forEach var="num" begin="2" end="10" step="1">
						<option value="${num}">${num}</option>
					</c:forEach>
				</select>
			</div>
			<div class="d-flex justify-content-center align-items-center">
				<button type="button" class="btn btn-primary mx-2" id="buyBtn">바로 구매</button>
				<button type="button" class="btn btn-success mx-2" id="cartBtn">장바구니</button>
			</div>
		</div>
	</div>
</div>
<div>
	<!-- ${product.product.content} -->
</div>
<script>
	$(document).ready(function() {
		$("#buyBtn").on('click', function(e) {
			e.preventDefault();
			let productId = $("#productId").val();
			let qty = $("#productCount").val();
			if (!qty) {
				alert("갯수를 선택해주세요");
				return false;
			}
			
			$.ajax({
				type : "POST",
				url : "/order/directOrder",
				data : {
					"productId" : productId,
					"qty" : qty
				},
				success : function(data) {
					if (data.code == 200) {
						location.href("/order/order");
					} else {
						alert(data.error_message);
					}
				},
				error : function(e) {
					alert("저장 실패");
				}
			});
		});
		
		$("#cartBtn").on('click', function(e) {
			e.preventDefault();
			let productId = $("#productId").val();
			let qty = $("#productCount").val();
			if (!qty) {
				alert("갯수를 선택해주세요");
				return false;
			}
			
			$.ajax({
				type : "POST",
				url : "/cart/addToCart",
				data : {
					"productId" : productId,
					"qty" : qty
				},
				success : function(data) {
					if (data.code == 200) {
						 if (confirm("장바구니로 이동하시겠습니다?") == true){
							 location.href = "/cart/cart-view";
						 }else{
						     return false;
						 }
					} else {
						alert(data.error_message);
					}
				},
				error : function(e) {
					alert("저장 실패");
				}
			});
		});
	});
</script>