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

import com.learncode.models.Lophoc;
import com.learncode.services.LophocServices;

@Controller
@RequestMapping("/lophoc")
public class LophocController {
	@Autowired
	LophocServices lophocServices;
	
	@RequestMapping("/list")
	public String list(ModelMap model, HttpSession session) {
		if (session.getAttribute("USERNAME")!= null) {
			model.addAttribute("LIST_LOPHOC", lophocServices.findAll());
			return "view-lophoc";
		}
		return "login";
	}
	
	@PostMapping("/checklogin")
	public String checkLogin(ModelMap model, @RequestParam("username")String username,
			@RequestParam("password") String password,
			HttpSession session) {
		if (lophocServices.checkLogin(username, password)) {
			System.out.println("Login successful");
			session.setAttribute("USERNAME", username);
			model.addAttribute("LIST_GIAOVIEN",lophocServices.findAll());
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
	public String addOrEdit(ModelMap model) {
		Lophoc lophoc= new Lophoc();
		model.addAttribute("LOPHOC",lophoc);
		model.addAttribute("ACTION","/lophoc/saveOrUpdate");
		return "addlophoc";
	}
	@PostMapping("/saveOrUpdate")
	public String saveOrUpdate(ModelMap model, @ModelAttribute("LOPHOC")Lophoc lophoc) {
		lophocServices.save(lophoc);
		return "addlophoc";
	}
	@RequestMapping("/edit/{id}")
	public String edit(ModelMap model,@PathVariable(name="id")Integer id) {
//		
		Optional<Lophoc> u= lophocServices.findById(id);
		if (u.isPresent()) {
			model.addAttribute("LOPHOC",u.get());
		}else {
			model.addAttribute("LOPHOC",new Lophoc());
		}
		
		model.addAttribute("ACTION","/lophoc/saveOrUpdate");
		return "addlophoc";
	}
	@RequestMapping("/delete/{id}")
	public String delete(ModelMap model,@PathVariable(name="id") Integer id) {
		lophocServices.deleteById(id);
		model.addAttribute("LIST_LOPHOC", lophocServices.findAll());
		return "redirect:/lophoc/list";
	}
}
