package com.greenstar.security.GreenStarSecurity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class GreenStarSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreenStarSecurityApplication.class, args);
	}

	@Bean
	public CorsFilter corsfilter() {
		
		final UrlBasedCorsConfigurationSource configSource =
				new UrlBasedCorsConfigurationSource();
		
		final CorsConfiguration config = 
				new CorsConfiguration();
		List<String> allowedMethods = new ArrayList<String>();
		allowedMethods.add("OPTIONS");
		allowedMethods.add("POST");
		allowedMethods.add("GET");
		allowedMethods.add("PUT");
		allowedMethods.add("DELETE");
		config.setAllowCredentials(true);
		config.addAllowedHeader("*");
		config.addAllowedOrigin("*");
		config.setAllowedMethods(allowedMethods);
		
		configSource.registerCorsConfiguration("/**", config);
		return new CorsFilter((CorsConfigurationSource) configSource);
	}
}
