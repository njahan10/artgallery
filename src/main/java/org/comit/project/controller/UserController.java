package org.comit.project.controller;

import org.comit.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
    @Controller
public class UserController {
	@Autowired
	UserService userservice;

	 @GetMapping("/")
	public String index() {
	       System.out.println("Show index page");
		   return "index";	
	 }
}
