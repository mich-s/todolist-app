package com.michal.todolist.tests;

import static org.hamcrest.Matchers.nullValue;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrlPattern;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.FormLoginRequestBuilder;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.michal.todolist.config.AppConfig;
import com.michal.todolist.config.SecurityConfig;


@SpringJUnitWebConfig(classes= {AppConfig.class, SecurityConfig.class} )
public class ApplicationTests {

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext wac;
	
	@BeforeEach
	void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).apply(springSecurity()).build();
	}
	
	@Test
	void loginWithValidUserThenAuthenticated() throws Exception{
		FormLoginRequestBuilder login = formLogin("/authenticateTheUser").user("jim").password("jim");
		
		this.mockMvc.perform(login)
					.andExpect(authenticated().withUsername("jim"));	
	}
	
	@Test
	void loginWithInvalidUserThenUnauthenticated() throws Exception{
		FormLoginRequestBuilder login = formLogin("/authenticateTheUser").user("invalidUser").password("invalidPassword");
		
		this.mockMvc.perform(login)
					.andExpect(unauthenticated());
	}
	
	@Test
    public void accessSecuredResourceUnauthenticatedThenRedirectsToLogin() throws Exception {
        mockMvc.perform(get("/"))
            .andExpect(status().is3xxRedirection())
            .andExpect(redirectedUrlPattern("**/showLoginForm"));
    }
    
    @Test
    @WithMockUser
    public void accessSecuredResourceAuthenticatedThenOkss() throws Exception {
    	mockMvc.perform(get("/"))
    		   .andExpect(status().isOk())
    		   .andExpect(view().name("home"))
    		   .andExpect(model().attribute("todolist", nullValue()))
    		   .andExpect(forwardedUrl("/WEB-INF/view/home.jsp"));
    }
	
    
    
	@Configuration
	static class UserAuthenticationPasswordEncoder {
		
		@SuppressWarnings("deprecation")
		@Bean
		public static NoOpPasswordEncoder passwordEncoder() {
			return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
		}
	}
	
	
	
}
