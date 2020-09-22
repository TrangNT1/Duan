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

import com.learncode.models.Diem;
import com.learncode.models.Giaovien;
import com.learncode.models.Monhoc;
import com.learncode.models.Sinhvien;
import com.learncode.services.DiemServices;
import com.learncode.services.GiaovienServices;
import com.learncode.services.MonhocServices;
import com.learncode.services.SinhvienServices;

@Controller
@RequestMapping("/diem")
public class DiemController {
	@Autowired
	DiemServices diemServices;
	
	@Autowired
	GiaovienServices giaovienServices;
	
	@Autowired
	SinhvienServices sinhvienServices;
	
	@Autowired
	MonhocServices monhocServices;

	@ModelAttribute(name ="SINHVIEN")
	public List<Sinhvien> getAllSinhvien(){
		return diemServices.findAllSinhvien();
	}
	@ModelAttribute(name ="GIAOVIEN")
	public List<Giaovien> getAllGiaovien(){
		return diemServices.findAllGiaovien();
	}
	@ModelAttribute(name ="MONHOC")
	public List<Monhoc> getAllMonhoc(){
		return diemServices.findAllMonhoc();
	}
	
	@RequestMapping("/list")
	public String list(ModelMap model, HttpSession session) {
		if (session.getAttribute("USERNAME")!= null) {
			model.addAttribute("LIST_DIEM", diemServices.findAll());
			return "view-diem";
		}
		return "login";
	}
	
	@PostMapping("/checklogin")
	public String checkLogin(ModelMap model, @RequestParam("username")String username,
			@RequestParam("password") String password,
			HttpSession session) {
		if (diemServices.checkLogin(username, password)) {
			System.out.println("Login successful");
			session.setAttribute("USERNAME", username);
			model.addAttribute("LIST_GIAOVIEN",diemServices.findAll());
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
		Diem diem= new Diem();
		model.addAttribute("DIEM",diem);
		model.addAttribute("SINHVIEN", sinhvienServices.findAll());
		model.addAttribute("GIAOVIEN", giaovienServices.findAll());
		model.addAttribute("MONHOC",monhocServices.findAll());
		model.addAttribute("ACTION","/diem/saveOrUpdate");
		return "adddiem";
	}

	@PostMapping("/saveOrUpdate")
	public String saveOrUpdate(ModelMap model, @ModelAttribute("DIEM")Diem diem) {
		diemServices.save(diem);
		return "adddiem";
	}
	
	
	@RequestMapping("/edit/{id}")
	public String edit(ModelMap model,@PathVariable(name="id")Integer id) {
//		
		Optional<Diem> u= diemServices.findById(id);
		if (u.isPresent()) {
			model.addAttribute("DIEM",u.get());
		}else {
			model.addAttribute("DIEM",new Diem());
		}
		
		model.addAttribute("ACTION","/diem/saveOrUpdate");
		return "adddiem";
	}
	@RequestMapping("/delete/{id}")
	public String delete(ModelMap model,@PathVariable(name="id") Integer id) {
		diemServices.deleteById(id);;
		model.addAttribute("LIST_DIEM", diemServices.findAll());
		return "redirect:/diem/list";
	}

}
