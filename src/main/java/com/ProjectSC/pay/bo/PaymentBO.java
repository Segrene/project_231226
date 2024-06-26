package com.ProjectSC.pay.bo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.ProjectSC.order.bo.OrderBO;
import com.ProjectSC.order.domain.Order;

import reactor.core.publisher.Mono;

@Service
public class PaymentBO {
	
	@Autowired
	private OrderBO orderBO;
	
	private final WebClient webClient;
	
	public PaymentBO(WebClient webClient) {
		this.webClient = webClient;
	}
	
	public Map<String, Object> paymentCompletion (String paymentId, int orderId) {
		String url = "/payments/payment-" + paymentId;
		Map<String, Object> result = new HashMap<>();
		Map<String, Object> paymentMap = webClient.get().uri(url).retrieve()
				.onStatus(httpStatus -> httpStatus != HttpStatus.OK,
				    clientResponse -> {
				      return clientResponse.createException()
				         .flatMap(it -> Mono.error(new RuntimeException("code : " + clientResponse.statusCode())));
				      })
				.bodyToMono(Map.class)
				.onErrorResume(throwable -> {
				    return Mono.error(new RuntimeException(throwable));
				}).block();
		Order preOrder = orderBO.getPreOrder(orderId);
		if (Integer.parseInt(paymentMap.get("amount").toString().split(", ")[0].split("=")[1]) != preOrder.getTotalAmount()) {
			result.put("code", 500);
			result.put("error_message", "결제 금액이 올바르지 않습니다.");
			paymentCancel(paymentId);
		} else {
			result.put("code", 200);
			result.put("result", "성공");
		}
		return result;
	}
	
	public Map<String, Object> paymentCancel (String paymentId) {
		String url = "/payments/payment-" + paymentId + "/cancel";
		Map<String, Object> paymentCancelMap = webClient.post().uri(url).bodyValue("{\"reason\":\"reason\"}").retrieve()
				.onStatus(httpStatus -> httpStatus != HttpStatus.OK,
			    clientResponse -> {
			      return clientResponse.createException()
			         .flatMap(it -> Mono.error(new RuntimeException("code : " + clientResponse.statusCode())));
			      })
				.bodyToMono(Map.class)
				.onErrorResume(throwable -> {
				    return Mono.error(new RuntimeException(throwable));
				}).block();
		return paymentCancelMap;
	}
	
	public Map<String, Object> paymentCompletionDebug (String paymentId) {
		String url = "/payments/payment-" + paymentId;
		Map<String, Object> paymentMap = webClient.get().uri(url).retrieve()
				.bodyToMono(Map.class).block();
		return paymentMap;
	}
}
