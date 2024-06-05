package com.ProjectSC.pay.bo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class PaymentBO {
	
	private final WebClient webClient;
	
	public PaymentBO(WebClient webClient) {
		this.webClient = webClient;
	}
	
	public Map<String, Object> paymentCompletion (String paymentId) {
		String url = "/payments/" + paymentId;
		Map<String, Object> result = new HashMap<>();
		Map<String, Object> paymentMap = webClient.get().uri(url).retrieve()
				.bodyToMono(Map.class).block();
		if (Integer.parseInt(paymentMap.get("amount").toString().split(", ")[0].split("=")[1]) != 100) {
			result.put("code", 500);
			result.put("error_message", "결제 금액이 올바르지 않습니다.");
		} else {
			result.put("code", 200);
			result.put("result", "성공");
		}
		return result;
	}
	
	public Map<String, Object> paymentCancel (String paymentId) {
		String url = "/payments/" + paymentId + "/cancel";
		Map<String, Object> paymentCancelMap = webClient.post().uri(url).bodyValue("{\"reason\":\"reason\"}").retrieve()
				.bodyToMono(Map.class).block();
		return paymentCancelMap;
	}
	
	public Map<String, Object> paymentCompletionDebug (String paymentId) {
		String url = "/payments/" + paymentId;
		Map<String, Object> paymentMap = webClient.get().uri(url).retrieve()
				.bodyToMono(Map.class).block();
		return paymentMap;
	}
}
