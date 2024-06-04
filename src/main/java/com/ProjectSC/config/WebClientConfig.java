package com.ProjectSC.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
	
	@Bean
	public WebClient webClient(WebClient.Builder builder) {
		return builder.baseUrl("https://api.portone.io")
				.defaultHeaders(httpHeaders -> {
					httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
					httpHeaders.add(HttpHeaders.AUTHORIZATION, "PortOne PFB3vzHtygadhED1uwujc8XJNatJ6Wlq7nTuYX6hnlcvacQeoFykk4lVqCyy4VHw9Rkzmleg7hW4aX0N");
				})
				.build();
	}

}
