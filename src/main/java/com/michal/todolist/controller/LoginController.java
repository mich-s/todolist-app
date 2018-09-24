package com.michal.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/showLoginForm")
	public String showLoginPage() {
		return "login-form";
	}
	
	
	/*@GetMapping("/accessDenied")
	public String showAccessDenied() {
		return "access-denied";
	}*/
	
}
