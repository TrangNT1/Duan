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

import com.learncode.models.Monhoc;
import com.learncode.services.MonhocServices;

@Controller
@RequestMapping("/monhoc")
public class MonhocController {
	@Autowired
	MonhocServices monhocServices;
	
	
	@RequestMapping("/list")
	public String list(ModelMap model, HttpSession session) {
		if (session.getAttribute("USERNAME")!= null) {
			model.addAttribute("LIST_MONHOC", monhocServices.findAll());
			return "view-monhoc";
		}
		return "login";
	}
	
	@PostMapping("/checklogin")
	public String checkLogin(ModelMap model, @RequestParam("username")String username,
			@RequestParam("password") String password,
			HttpSession session) {
		if (monhocServices.checkLogin(username, password)) {
			System.out.println("Login successful");
			session.setAttribute("USERNAME", username);
			model.addAttribute("LIST_GIAOVIEN",monhocServices.findAll());
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
		Monhoc monhoc= new Monhoc();
		model.addAttribute("MONHOC",monhoc);
		model.addAttribute("ACTION","/monhoc/saveOrUpdate");
		return "addmonhoc";
	}
	@PostMapping("/saveOrUpdate")
	public String saveOrUpdate(ModelMap model, @ModelAttribute("MONHOC")Monhoc monhoc) {
		monhocServices.save(monhoc);
		return "addmonhoc";
	}
	@RequestMapping("/edit/{id}")
	public String edit(ModelMap model,@PathVariable(name="id")Integer id) {
//		
		Optional<Monhoc> u= monhocServices.findById(id);
		if (u.isPresent()) {
			model.addAttribute("MONHOC",u.get());
		}else {
			model.addAttribute("MONHOC",new Monhoc());
		}
		
		model.addAttribute("ACTION","/monhoc/saveOrUpdate");
		return "addmonhoc";
	}
	@RequestMapping("/delete/{id}")
	public String delete(ModelMap model,@PathVariable(name="id") Integer id) {
		monhocServices.deleteById(id);
		model.addAttribute("LIST_MONHOC", monhocServices.findAll());
		return "redirect:/monhoc/list";
	}
}
