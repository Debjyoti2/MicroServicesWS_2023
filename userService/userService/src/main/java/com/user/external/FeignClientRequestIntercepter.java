package com.user.external;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.stereotype.Component;

import feign.RequestInterceptor;
import feign.RequestTemplate;

@Configuration
@Component
public class FeignClientRequestIntercepter implements RequestInterceptor{
	
	@Autowired
	private OAuth2AuthorizedClientManager oAuth2AuthorizedClientManager;
	
	@Override
	public void apply(RequestTemplate template) {
		
	 String token= oAuth2AuthorizedClientManager
			       .authorize(OAuth2AuthorizeRequest
			    		      .withClientRegistrationId("user-service")
			    		      .principal("internal")
			    		      .build())
			       .getAccessToken()
			       .getTokenValue();
    
	 template.header("Authorization","Bearer "+token);
		
		
	}

}
