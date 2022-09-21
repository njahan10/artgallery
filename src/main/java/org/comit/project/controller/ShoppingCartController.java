package org.comit.project.controller;

import java.util.List;

import org.comit.project.bean.ShoppingCart;
import org.comit.project.bean.User;
import org.comit.project.service.ShoppingCartService;
import org.comit.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShoppingCartController {
	
	@Autowired
	ShoppingCartService shoppingCartService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/shoppingcart")
	public ModelAndView index() {
		User user = this.getCurrentUser(); 
		List<ShoppingCart> shoppingCarts = shoppingCartService.listItems(user.id);
		return new ModelAndView("shoppingcart", "shoppingCarts", shoppingCarts);
	}
	
	@GetMapping("/shoppingcart/remove/{cartId}")
	public String removeItem(@PathVariable("cartId") long cartId) {
		this.shoppingCartService.remove(cartId);
		return "redirect:/shoppingcart";
	}
	
	@GetMapping("/shoppingcart/add/{artId}")
	public String addItem(@PathVariable("artId") long artId) {
		User user = this.getCurrentUser(); 
		this.shoppingCartService.addItem(artId, user.getId(), 1);
		return "redirect:/shoppingcart";
	}
	
	private User getCurrentUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = "";
		 if(principal instanceof UserDetails) {
			 userName = ((UserDetails)principal).getUsername();
		 }else {
			 userName = principal.toString();
		 }
		 
		 return userService.findByUsername(userName); 
	}
}
