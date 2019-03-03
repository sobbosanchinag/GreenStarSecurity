package com.greenstar.security.GreenStarSecurity;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JWTAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable{

	public void commence(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse,
			AuthenticationException authenticationException
			) throws IOException, ServletException{
		
		httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
	}
	
}
