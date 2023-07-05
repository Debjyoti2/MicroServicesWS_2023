package com.apigateway.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class OktaSecurityConfig {
	
	@Bean
	public SecurityWebFilterChain securitWebFilterChain(ServerHttpSecurity httpSecurity) {
		
		httpSecurity
		    .authorizeExchange()
		    .anyExchange()
		    .authenticated()
		    .and()
		    .oauth2Login()
		    .and()
		    .oauth2ResourceServer()
		    .jwt();
		
		return httpSecurity.build();
	}

}
