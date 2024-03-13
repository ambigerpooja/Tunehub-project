package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Users;
import com.example.demo.services.UserService;

@Controller
public class UsersController
{
	@Autowired
	UserService userv;

	
	@PostMapping("/register")
	public String addUser(@ModelAttribute Users user)
	{
		boolean userstatus=userv.emailExists(user.getEmail());
		if(userstatus==false)
		{
			userv.addUser(user);
			return"registersuccess";
		}
		else
		{
			return"registerfail";
		}
		
	}
	
	@PostMapping("/login")
	public String validateUser(@RequestParam String email,@RequestParam String password)
	{
		boolean loginstatus=userv.validateUser(email, password);
		if(loginstatus==true)
		{
			if(userv.getRole(email).equals("admin")) 
			{
				return "adminhome";
			}
			else
			{
				return "customerhome";
			}
				
		}
		else
		{
			return"loginfail";
		}
				
	}
	
}
