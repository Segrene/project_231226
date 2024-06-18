<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
	crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="/static/css/style.css">
<title>ProjectSC</title>
</head>
<body>
<div class="container d-flex justify-content-center p-0">
		<div id="wrap" class="w-100">
			<div class="d-flex align-items-center">
				<div class="logo bg-danger" onclick="location.href='/main/main';"
					style="cursor: pointer;"></div>
				<h1>결제 결과</h1>
			</div>
			<div class="d-none" id="orderId">${order.id}</div>
			<div class="cart-form bg-light d-flex justify-content-center w-100">
				<div class="border" id="orderItems">
					<div class="border font-weight-light p-5" id="cartTotal">
						<div class="d-flex aling-items-center">
							<div>전체 가격 : ${order.amount}</div>
						</div>
						<div class="d-flex aling-items-center">
							<div>전체 배송료 : ${order.deliveryFee}</div>
						</div>
						<div class="d-flex aling-items-center">
							<div>최종 가격 : ${order.totalAmount}</div>
						</div>
						<div class="d-flex aling-items-center">
							<div>결제일 : ${order.createdAt}</div>
						</div>
						<div class="d-flex aling-items-center">
							<div>결제수단 : ${order.paymentMethod}</div>
						</div>
						<hr>
						<div class="d-flex aling-items-center">
							<div>배송지 : ${order.address}</div>
						</div>
						<div class="d-flex aling-items-center">
							<div>수령인 : ${order.receiver}</div>
						</div>
						<div class="d-flex aling-items-center">
							<div>연락처 : ${order.contact}</div>
						</div>
						<div class="d-flex aling-items-center">
							<div>예상 배송완료일 : ${order.estimated}</div>
						</div>
					</div>
					<div class="d-flex justify-content-center">
						<a href="/main/main" class="btn btn-primary">메인으로</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>