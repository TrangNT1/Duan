package com.learncode.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.learncode.models.User;
import com.learncode.services.UserServices;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserServices userServices;
	public boolean validateForAdd(@ModelAttribute("USER") User user,HttpSession session) {
		if (user.getUsername().equals("") || user.getUsername() == null) {
			session.setAttribute("MESUSERNAME", "You have not entered a username");
			return false;
		}
		if (user.getPassword().isEmpty() || user.getPassword() == null) {
			session.setAttribute("MESPASSWORD", "You have not entered a password");
			return false;
		}
		if (user.getPassword().length() < 6) {
			session.setAttribute("MESPASSWORD", "Password must contain at least 6 characters");
			return false;
		}
		return true;
	}
	
	
	@RequestMapping("/list")
	public String list(ModelMap model, HttpSession session) {
		if (session.getAttribute("USERNAME")!= null) {
			model.addAttribute("LIST_USER",userServices.findAll());
			return "view-user";
		}
		return "login";
		
	}
	
	@RequestMapping("/login")
	public String showLogin() {
		return "login"; 
	}
	@PostMapping("/checklogin")
	public String checkLogin(ModelMap model, @RequestParam("username")String username,
			@RequestParam("password") String password,
			HttpSession session) {
		if (userServices.checkLogin(username, password)) {
			System.out.println("Login successful");
			session.setAttribute("USERNAME", username);
			model.addAttribute("LIST_USER",userServices.findAll());
			return "/layout/main-layout";
		}else {
			System.out.println("Login faild");
			model.addAttribute("ERROR","Username or password not exist");
		}
		return "login";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("USERNAME");
		return "redirect:/user/login";
	}
	@GetMapping("/")
	public String addOrEdit(ModelMap model,HttpSession session) {
		User user = new User();
		model.addAttribute("USER",user);
		model.addAttribute("ACTION","/user/saveOrUpdate");
		session.setAttribute("MESSUB", "");
		session.setAttribute("MESUSERNAME", "");
		session.setAttribute("MESPASSWORD", "");
		return "adduser";
	}
	
	@PostMapping("/saveOrUpdate")
	public String saveOrUpdate(ModelMap model,@ModelAttribute("USER") User user,HttpSession session) {
		User u = userServices.findByUsername(user.getUsername());
		if (!validateForAdd(user, session)) {
			return "adduser";
		}else {
			if ( u!= null &&  u.getUsername() != user.getUsername()) {
				session.setAttribute("MESUSERNAME","The username already exists");
				return "adduser";
			}
			if (!userServices.checkExits(user)) {
				userServices.save(user);
				session.setAttribute("MESSUB","saved successfully");
				session.setAttribute("MESUSERNAME", "");
				session.setAttribute("MESPASSWORD", "");
			}
		}
		
		return "adduser";
	}
	
	
	@RequestMapping("/edit/{id}")
	public String edit(ModelMap model,@PathVariable(name="id")String id,HttpSession session) {
//		
		Optional<User> u= userServices.findById(id);
		if (u.isPresent()) {
			model.addAttribute("USER",u.get());
		}else {
			model.addAttribute("USER",new User());
		}
		
		model.addAttribute("ACTION","/user/saveOrUpdate");
		session.setAttribute("MESSUB", "");
		session.setAttribute("MESUSERNAME", "");
		session.setAttribute("MESPASSWORD", "");
		return "adduser";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(ModelMap model,@PathVariable(name="id") String id) {
		userServices.deleteById(id);
		model.addAttribute("LIST_USER", userServices.findAll());
		return "redirect:/user/list";
	}
	
	
	
	
}
