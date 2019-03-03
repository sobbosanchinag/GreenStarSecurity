package com.greenstar.security.interceptor;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jersey.JerseyAutoConfiguration.JerseyWebApplicationInitializer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public class AuthenticationTokenFilter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JWTokenUtil jwTokenUtil;
	
	@Value("${jwt.header}")
	private String tokenHeader;
	
	public void doFilterInternal(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, FilterChain filterChain) 
			throws IOException, ServletException{
		
		String authToken = httpServletRequest.getHeader(this.tokenHeader);
		
		if(authToken!=null && authToken.length() >7 ) {
			authToken.substring(7);
			
		}
		String userName = JWTokenUtil.getUserNameFromToken(authToken);
	}
	
}
