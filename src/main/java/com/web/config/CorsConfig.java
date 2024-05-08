package com.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();

		// Allow requests from http://localhost:5173
		config.addAllowedOrigin("http://localhost:5173");

		// Allow the content-type header
		config.addAllowedHeader("content-type");

		// Allow POST method
		config.addAllowedMethod("POST");

		source.registerCorsConfiguration("/", config);
		return new CorsFilter(source);
	}
}