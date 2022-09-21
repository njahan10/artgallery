package org.comit.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.comit.project.bean.Role;
import org.comit.project.bean.User;
import org.comit.project.bean.UserRoles;
import org.comit.project.service.RoleService;
import org.comit.project.service.UserService;
import org.comit.project.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	RoleService roleService;

	@Autowired
	UserService userService;

	@GetMapping("/user/userlist")
	public ModelAndView index() {
		List<User> users = userService.listUsers();
		return new ModelAndView("userlist", "users", users);
	}

	@GetMapping("/user/create")
	public ModelAndView showCreate() {
		logger.debug("Show Create");

		List<Role> roles = this.roleService.listRoles();

		return new ModelAndView("createuser", "roles", roles);
	}

	@PostMapping("/user/create")
	public String createUser(HttpServletRequest request) {
		logger.debug("Create User");
		String first = request.getParameter("first");
		String last = request.getParameter("last");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String birth = request.getParameter("birth");
		String roleId = request.getParameter("role");
		User user = this.createUser(null, first, last, username, email, password, birth, roleId);
		this.userService.createUser(user);
		return "redirect:/user/userlist";
	}

	@GetMapping("/user/update/{id}")
	public ModelAndView showUpdate(@PathVariable("id") int id) {

		logger.debug("Show Update");
		User user = this.userService.findUser(id);
		List<Role> roles = this.roleService.listRoles();
		UserRoles userRoles = new UserRoles(user, roles);
		return new ModelAndView("updateuser", "userRoles", userRoles);
	}

	@PostMapping("/user/update")
	public String updateUser(HttpServletRequest request) {
		logger.debug("Update User");
		String userId = request.getParameter("userid");
		String first = request.getParameter("first");
		String last = request.getParameter("last");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String birth = request.getParameter("birth");

		String roleId = request.getParameter("role");

		User user = this.createUser(userId, first, last, username, email, password, birth, roleId);

		this.userService.modifyUser(user);

		return "redirect:/user/userlist";
	}

	@GetMapping("/user/delete/{id}")
	public String deleteUser(@PathVariable("id") int id) {
		logger.debug("Delete User");
		this.userService.deleteUser(id);
		return "redirect:/user/userlist";
	}
	
	private User createUser(String userId, String first, String last, String username, String email, String password, String birth, String roleId) {


		Role role = new Role(Util.parseId(roleId));

		User user = new User(Util.parseId(userId),first.trim(),last.trim(),username.trim(), email.trim(), password,Util.parseDate(birth),"",role);

		return user;
	}

}
