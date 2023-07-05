package com.apigateway.controller;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apigateway.model.AuthenticationResponse;

@RestController
@RequestMapping("/authenticate")
public class OktaAuthenticationController {

	@GetMapping("/login")
	public ResponseEntity<AuthenticationResponse> login(
			@AuthenticationPrincipal OidcUser oidcUser,
			@RegisteredOAuth2AuthorizedClient("okta")  OAuth2AuthorizedClient  client,
			Model model ){
	
	AuthenticationResponse response = AuthenticationResponse.builder()
			                         .userId(oidcUser.getEmail())
			                         .accessToken(client.getAccessToken().getTokenValue())
			                         .refreshToken(client.getRefreshToken().getTokenValue())
			                         .expireAt(oidcUser.getExpiresAt().getEpochSecond())
			                         .authorityList(oidcUser.getAuthorities().stream().map(GrantedAuthority :: getAuthority).collect(Collectors.toList()))
			                         .build();
	return new ResponseEntity<AuthenticationResponse>(response,HttpStatus.OK);
	
	}
	
	/*
	  Passwords:
	  debjyotiroychoudhury2012@yahoo.com - Pass@12345
	  anupamsaha270@gmail.com  - Pass@123

	 * 
	 */
	
}
