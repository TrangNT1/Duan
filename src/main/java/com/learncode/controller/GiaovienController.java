package com.learncode.controller;


import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.learncode.models.Giaovien;
import com.learncode.models.Lophoc;
import com.learncode.services.GiaovienServices;
import com.learncode.services.LophocServices;



@Controller
@RequestMapping("/giaovien")
public class GiaovienController {
	@Autowired
	GiaovienServices giaovienServices;
	
	@Autowired
	LophocServices lophocServices;
	
	@ModelAttribute(name ="LOPHOC")
	public List<Lophoc> getAllLophoc(){
		return giaovienServices.findAllLophoc();
	}

	
	@RequestMapping("/list")
	public String list(ModelMap model, HttpSession session) {
		if (session.getAttribute("USERNAME")!= null) {
		model.addAttribute("LIST_GIAOVIEN", giaovienServices.findAll());
		return "view-giaovien";
		}
		return "login";
	}
	
	@PostMapping("/checklogin")
	public String checkLogin(ModelMap model, @RequestParam("username")String username,
			@RequestParam("password") String password,
			HttpSession session) {
		if (giaovienServices.checkLogin(username, password)) {
			System.out.println("Login successful");
			session.setAttribute("USERNAME", username);
			model.addAttribute("LIST_GIAOVIEN",giaovienServices.findAll());
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
		Giaovien giaovien= new Giaovien();
		model.addAttribute("GIAOVIEN",giaovien);
		model.addAttribute("LOPHOC", lophocServices.findAll());
		model.addAttribute("ACTION","/giaovien/saveOrUpdate");
		return "addgiaovien";
	}
	
	@PostMapping("/saveOrUpdate")
	public String saveOrUpdate(ModelMap model, @ModelAttribute("GIAOVIEN")Giaovien giaovien) {
		giaovienServices.save(giaovien);
		return "addgiaovien";
	}
	@GetMapping("/find")
	public String findGiaovien(@RequestParam(name = "like", required = false) String name,
			@RequestParam(name = "page", required = false) Integer page, 
			@RequestParam(name = "limit", required = false) Integer limit, ModelMap model){
		if(null == page) page = 0;
		if(null == limit) limit = 10;
		Pageable pageable = PageRequest.of(page, limit);
		model.addAttribute("LIST_GIAOVIEN", giaovienServices.findGiaovienContainName(name, pageable).getContent());
		return "view-gv";
	}
	@RequestMapping("/edit/{id}")
	public String edit(ModelMap model,@PathVariable(name="id")Integer id,HttpSession session) {
//		
		Optional<Giaovien> u= giaovienServices.findById(id);
		if (u.isPresent()) {
			model.addAttribute("GIAOVIEN",u.get());
		}else {
			model.addAttribute("GIAOVIEN",new Giaovien());
		}
		
		model.addAttribute("ACTION","/giaovien/saveOrUpdate");
		return "addgiaovien";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(ModelMap model,@PathVariable(name="id") Integer id) {
		giaovienServices.deleteById(id);
		model.addAttribute("LIST_GIAOVIEN", giaovienServices.findAll());
		return "redirect:/giaovien/list";
	}
	
	
	
	
}
