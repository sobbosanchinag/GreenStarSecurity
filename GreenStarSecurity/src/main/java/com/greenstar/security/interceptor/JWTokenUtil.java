package com.greenstar.security.interceptor;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;

@Component
public class JWTokenUtil implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3479807452503461903L;
	
	static final String CLAM_KEY_USERNAME = "sub";
	static final String CLAM_KEY_AUDIENCE = "audience";
	static final String CLAM_KEY_CREATED = "created";

	@Value("${jwt.security}")
	private String secret;
	
	@Value("${jwt.expiration}")
	private Long expiration;
	
	public static String getUserNameFromToken(String token) {
		// TODO Auto-generated method stub
		String userName = null;
		final Claims claims = getClaimsFromToken(token);
		userName = claims.getSubject();
		return null;
	}

	private static Claims getClaimsFromToken(String token) {
		// TODO Auto-generated method stub
		
		
		return null;
	}

}
