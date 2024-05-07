package com.example.schedulerEx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.schedulerEx.service.UserService;

@Controller
public class MyController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public @ResponseBody String root() {
		return "Scheduler Ex....";
	}
	
	@RequestMapping("/notifyUsers")
	public String notifyUsers(Model model) {
		String message = userService.notifyInactiveUsers();
		model.addAttribute("message", message);
		
		return "notification";
	}
}
