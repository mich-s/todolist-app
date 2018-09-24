package com.michal.todolist.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.michal.todolist.entity.TodoListUser;

@Controller
public class RegisterUserController {

	@Autowired
	private UserDetailsManager userDetailsManager;
	
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}	
	
	
	@GetMapping("/showRegistrationForm")
	public String showMyLoginPage(Model theModel) {
		theModel.addAttribute("todoListUser", new TodoListUser());
		return "registration-form";
	}

	@PostMapping("/processRegistrationForm")
	public String processRegistrationForm(
				@Valid @ModelAttribute("todoListUser") TodoListUser todoListUser, 
				BindingResult theBindingResult, 
				Model theModel) {
						
		String userName = todoListUser.getUsername();
		
		if (theBindingResult.hasErrors()) {
			theModel.addAttribute("todoListUser", new TodoListUser());
			theModel.addAttribute("registrationError", "User name/password can not be empty.");
			return "registration-form";	
		}
		
		boolean userExists = doesUserExist(userName);
		if (userExists) {
			theModel.addAttribute("todoListUser", new TodoListUser());
			theModel.addAttribute("registrationError", "User name already exists.");
			return "registration-form";			
		}
		
        String encodedPassword = passwordEncoder.encode(todoListUser.getPassword());
        encodedPassword = "{bcrypt}" + encodedPassword;
        List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_USER");
        User tempUser = new User(userName, encodedPassword, authorities);
        userDetailsManager.createUser(tempUser);
        
        return "registration-confirmation";		
	}
	
	private boolean doesUserExist(String userName) {
		boolean exists = userDetailsManager.userExists(userName);
		return exists;
	}
	

	
}
