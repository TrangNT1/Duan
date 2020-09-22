package com.learncode.controller;

import java.util.List;
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
import com.learncode.models.Sinhvien;
import com.learncode.services.LophocServices;
import com.learncode.services.SinhvienServices;

@Controller
@RequestMapping("/sinhvien")
public class SinhvienController {
	@Autowired
	SinhvienServices sinhvienServices;
	
	@Autowired
	LophocServices lophocServices;
	
	@ModelAttribute(name ="LOPHOC")
	public List<Lophoc> getAllLophoc(){
		return sinhvienServices.findAllLophoc();
	}
	
	@RequestMapping("/list")
	public String list(ModelMap model, HttpSession session) {
		if (session.getAttribute("USERNAME")!= null) {
			model.addAttribute("LIST_SINHVIEN", sinhvienServices.findAll());
			return "view-sinhvien";
		}
		return "login";
	}
	
	@PostMapping("/checklogin")
	public String checkLogin(ModelMap model, @RequestParam("username")String username,
			@RequestParam("password") String password,
			HttpSession session) {
		if (sinhvienServices.checkLogin(username, password)) {
			System.out.println("Login successful");
			session.setAttribute("USERNAME", username);
			model.addAttribute("LIST_GIAOVIEN",sinhvienServices.findAll());
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
		Sinhvien sinhvien= new Sinhvien();
		model.addAttribute("SINHVIEN",sinhvien);
		model.addAttribute("LOPHOC", lophocServices.findAll());
		model.addAttribute("ACTION","/sinhvien/saveOrUpdate");
		return "addsinhvien";
	}

	@PostMapping("/saveOrUpdate")
	public String saveOrUpdate(ModelMap model, @ModelAttribute("SINHVIEN")Sinhvien sinhvien) {
		sinhvienServices.save(sinhvien);
		return "addsinhvien";
	}
	
	
	@RequestMapping("/edit/{id}")
	public String edit(ModelMap model,@PathVariable(name="id")Integer id) {
//		
		Optional<Sinhvien> u= sinhvienServices.findById(id);
		if (u.isPresent()) {
			model.addAttribute("SINHVIEN",u.get());
		}else {
			model.addAttribute("SINHVIEN",new Sinhvien());
		}
		
		model.addAttribute("ACTION","/sinhvien/saveOrUpdate");
		return "addsinhvien";
	}
	@RequestMapping("/delete/{id}")
	public String delete(ModelMap model,@PathVariable(name="id") Integer id) {
		sinhvienServices.deleteById(id);
		model.addAttribute("LIST_SINHVIEN", sinhvienServices.findAll());
		return "redirect:/sinhvien/list";
	}
}
