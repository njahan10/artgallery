package org.comit.project.controller;

import java.util.List;

import org.comit.project.bean.User;
import org.comit.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
    
@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	 
	
		@GetMapping("/user/list")
		public ModelAndView index() {
			List<User> users = userService.listUsers();
			return new ModelAndView("list", "users", users);
		}
//		@GetMapping("/user")
//		public String user() {
//			return "user";
//		}
//		
//		@GetMapping("/list")
//		public String list() {
//			return "list";
//		}	
//		@DeleteMapping("/delete")
//		public String delete() {
//			return "delete";
//
//		}
//		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
