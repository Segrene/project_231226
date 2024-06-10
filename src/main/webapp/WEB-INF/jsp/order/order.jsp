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
				<h1>결제</h1>
			</div>
			<div class="d-none" id="orderId">${order.id}</div>
			<div class="cart-form bg-light d-flex justify-content-center w-100">
				<div class="border" id="orderItems">
					<div class="border font-weight-light p-5" id="cartTotal">
						<div class="d-flex aling-items-center">
							<div>전체 가격 : ${order.amount}</div>
							<div class="cartProductPrice ml-1"></div>
						</div>
						<div class="d-flex aling-items-center">
							<div>전체 배송료 : ${order.deliveryFee}</div>
							<div class="cartDeliveryFee ml-1"></div>
						</div>
						<div class="d-flex aling-items-center">
							<div>최종 가격 : <div id=amount>${order.totalAmount}</div></div>
							<div class="cartDeliveryFee ml-1"></div>
						</div>
					</div>
				</div>
				<div class="border" id="orderOptions">
					<div class="border font-weight-light p-5" id="orderOption">
						<div class="font-weight-light text20">주소</div>
						<div class="py-2">
							<div class="input-group d-flex align-items-center py-1">
								<input type="text" class="form-control" id="zonecode" placeholder="우편번호">
								<button type="button" class="btn btn-primary addressBtn ml-5">주소 찾기</button>
							</div>
							<input type="text" class="form-control py-1" id="address" placeholder="주소">
							<input type="text" class="form-control py-1" id="addressDetail" placeholder="상세주소">
						</div>
						<div class="font-weight-light text20">결제방법</div>
						<div class="input-group mb-3 py-2">
							<div class="input-group-prepend">
								<label class="input-group-text" for="inputGroupSelect01">결제방식</label>
							</div>
							<select class="custom-select" id="payment">
								<option selected value="0">나이스페이먼츠</option>
								<option value="1">카카오페이 직연동</option>
							</select>
						</div>
						<div>
							<button type="button" class="btn btn-primary buyBtn">구매하기</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://cdn.portone.io/v2/browser-sdk.js"></script>
<script>
	
	let orderId = parseInt($('#orderId').text().trim());
	console.log(orderId);
	
	let amount = parseInt($('#amount').text().trim());
	console.log($('#amount').text().trim());
	console.log(amount);

	async function kakaoPay() {
		const response = await PortOne.requestPayment({
			// Store ID 설정
			storeId : "store-faae0eac-818e-408f-adc1-0a523d4413e7",
			// 채널 키 설정
			channelKey : "channel-key-b15a1ef6-1d44-470d-8a32-00f32fbb52a3",
			paymentId : `payment-${crypto.randomUUID()}`,
			// 추후 구현 예정
			orderName : "API 테스트 결제",
			totalAmount : amount,
			currency : "CURRENCY_KRW",
			payMethod : "EASY_PAY",
			easyPay : {
				easyPayProvider : "KAKAOPAY",
			},
			isTestChannel : true,
		});

		if (response.code != null) {
			// 오류 발생
			return alert(response.message);
		}

		// 고객사 서버에서 /payment/complete 엔드포인트를 구현해야 합니다.
		// (다음 목차에서 설명합니다)
		const notified = await
		fetch(`/payment/complete`, {
			method : "POST",
			headers : {
				"Content-Type" : "application/json"
			},
			// paymentId와 주문 정보를 서버에 전달합니다
			body : JSON.stringify({
				paymentId : paymentId,
			// 주문 정보...
			}),
		});
	}
	
	async function nicePayments() {
		let orderId = parseInt($('#orderId').text().trim());
		console.log(orderId);
		let zonecode = $("#zonecode").val();
		let address = $("#address").val();
		let addressDetail = $("#addressDetail").val();
		let mergedAddress = "(" + zonecode + ")" + address
				+ " " + addressDetail;
		console.log(mergedAddress);
		let paymentMethod = $("#payment").val();
		console.log(paymentMethod);
		let paymentId = crypto.randomUUID();
		console.log(paymentId);
		const response = await PortOne.requestPayment({
			// Store ID 설정
			storeId : "store-faae0eac-818e-408f-adc1-0a523d4413e7",
			// 채널 키 설정
			channelKey : "channel-key-70380733-aad8-4fa4-8ca5-02f8258bff39",
			paymentId : "payment-" + paymentId,
			// 추후 구현 예정
			orderName : "API 테스트 결제",
			totalAmount : amount,
			currency : "KRW",
			payMethod: "CARD",
		    card: {},
		    isTestChannel : true,
		});

		if (response.code != null) {
			// 오류 발생
			return alert(response.message);
		}

		// 고객사 서버에서 /payment/complete 엔드포인트를 구현해야 합니다.
		// (다음 목차에서 설명합니다)
		
		let payment = {
			paymentId: paymentId
			, address: mergedAddress
			, orderId: orderId
			, paymentMethod: paymentMethod
		}
		
		let resultJson = JSON.stringify(payment);
		
		console.log(resultJson);
		
		const notified = await
		fetch(`/payment/complete`, {
			method : "POST",
			headers : {
				"Content-Type" : "application/json"
			},
			// paymentId와 주문 정보를 서버에 전달합니다
			body : resultJson
		});
		
		console.log(notified);
		
		if (notified.status == 200) {
			  location.href = "/order/result";
		  }
	}

	$(document).ready(
			function() {
				$('.addressBtn').on('click', function(e) {
					new daum.Postcode({
						oncomplete : function(data) {
							$('#zonecode').val(data.zonecode);
							$('#address').val(data.address);
						}
					}).open();
				});
				$('.buyBtn').on(
						'click',
						function() {
							let zonecode = $("#zonecode").val();
							let address = $("#address").val();
							let addressDetail = $("#addressDetail").val();
							let mergedAddress = "(" + zonecode + ")" + address
									+ " " + addressDetail;
							console.log(mergedAddress);
							let paymentMethod = $("#payment").val();
							console.log(paymentMethod);
							if (paymentMethod == 0) {
								nicePayments();
							}
							if (paymentMethod == 1) {
								kakaoPay();
							}
						});
			});
</script>
</html>