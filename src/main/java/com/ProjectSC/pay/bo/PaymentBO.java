package com.ProjectSC.pay.bo;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class PaymentBO {
	
	private final WebClient webClient;
	
	public PaymentBO(WebClient webClient) {
		this.webClient = webClient;
	}
	
	public void paymentCompletion (String paymentId) {
		
	}
}
