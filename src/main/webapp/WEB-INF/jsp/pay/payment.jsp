<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>
<title>ProjectSC</title>
</head>
<body>

</body>
<script src="https://cdn.portone.io/v2/browser-sdk.js"></script>
<script>
async function requestPayment() {
	  const response = await PortOne.requestPayment({
		// Store ID 설정
		storeId: "store-faae0eac-818e-408f-adc1-0a523d4413e7",
		// 채널 키 설정
		channelKey: "channel-key-b15a1ef6-1d44-470d-8a32-00f32fbb52a3",
		paymentId: `payment-${crypto.randomUUID()}`,
		// 추후 구현 예정
		orderName: "API 테스트 결제",
		totalAmount: 1000,
		currency: "CURRENCY_KRW",
		payMethod: "EASY_PAY",
		easyPay: {
		      easyPayProvider: "KAKAOPAY",
		    }
	  });
	  
	  if (response.code != null) {
	    // 오류 발생
	    return alert(response.message);
	  }

	  // 고객사 서버에서 /payment/complete 엔드포인트를 구현해야 합니다.
	  // (다음 목차에서 설명합니다)
	  const notified = await fetch(`/payment/complete`, {
	    method: "POST",
	    headers: { "Content-Type": "application/json" },
	    // paymentId와 주문 정보를 서버에 전달합니다
	    body: JSON.stringify({
	      paymentId: paymentId,
	      // 주문 정보...
	    }),
	  });
	  
	  if (notified.code == 200) {
		  location.href = "/main/main";
	  }
	}
$(document).ready(function() {
	console.log("start");
	PortOne.requestPayment();
	console.log("end");
});
</script>
</html>