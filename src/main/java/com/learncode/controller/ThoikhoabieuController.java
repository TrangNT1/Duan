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

import com.learncode.models.Giaovien;
import com.learncode.models.Lophoc;
import com.learncode.models.Monhoc;
import com.learncode.models.Thoikhoabieu;
import com.learncode.services.GiaovienServices;
import com.learncode.services.LophocServices;
import com.learncode.services.MonhocServices;
import com.learncode.services.ThoikhoabieuServices;

@Controller
@RequestMapping("/thoikhoabieu")
public class ThoikhoabieuController {
	@Autowired
	ThoikhoabieuServices thoikhoabieuServices;
	
	@Autowired
	LophocServices lophocServices;
	
	@Autowired
	GiaovienServices giaovienServices;
	
	@Autowired
	MonhocServices monhocServices;
	
	@ModelAttribute(name ="LOPHOC")
	public List<Lophoc> getAllLophoc(){
		return thoikhoabieuServices.findAllLophoc();
	}
	@ModelAttribute(name ="GIAOVIEN")
	public List<Giaovien> getAllGiaovien(){
		return thoikhoabieuServices.findAllGiaovien();
	}
	
	@ModelAttribute(name ="MONHOC")
	public List<Monhoc> getAllMonhoc(){
		return thoikhoabieuServices.findAllMonhoc();
	}
	
	@RequestMapping("/list")
	public String list(ModelMap model, HttpSession session) {
		if (session.getAttribute("USERNAME")!= null) {
			model.addAttribute("LIST_THOIKHOABIEU", thoikhoabieuServices.findAll());
			return "view-tkb";
		}
		return "login";
	}
	
	@PostMapping("/checklogin")
	public String checkLogin(ModelMap model, @RequestParam("username")String username,
			@RequestParam("password") String password,
			HttpSession session) {
		if (thoikhoabieuServices.checkLogin(username, password)) {
			System.out.println("Login successful");
			session.setAttribute("USERNAME", username);
			model.addAttribute("LIST_GIAOVIEN",thoikhoabieuServices.findAll());
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
		Thoikhoabieu thoikhoabieu = new Thoikhoabieu();
		model.addAttribute("THOIKHOABIEU",thoikhoabieu);
		model.addAttribute("LOPHOC", lophocServices.findAll());
		model.addAttribute("GIAOVIEN", giaovienServices.findAll());
		model.addAttribute("MONHOC", monhocServices.findAll());
		model.addAttribute("ACTION","/thoikhoabieu/saveOrUpdate");
		return "addtkb";
	}

	@PostMapping("/saveOrUpdate")
	public String saveOrUpdate(ModelMap model, @ModelAttribute("THOIKHOABIEU")Thoikhoabieu thoikhoabieu) {
		thoikhoabieuServices.save(thoikhoabieu);
		return "addtkb";
	}
	
	
	@RequestMapping("/edit/{id}")
	public String edit(ModelMap model,@PathVariable(name="id")Integer id) {
//		
		Optional<Thoikhoabieu> u=thoikhoabieuServices.findById(id);
		if (u.isPresent()) {
			model.addAttribute("THOIKHOABIEU",u.get());
		}else {
			model.addAttribute("THOIKHOABIEU",new Thoikhoabieu());
		}
		
		model.addAttribute("ACTION","/thoikhoabieu/saveOrUpdate");
		return "addtkb";
	}
	@RequestMapping("/delete/{id}")
	public String delete(ModelMap model,@PathVariable(name="id") Integer id) {
		thoikhoabieuServices.deleteById(id);
		model.addAttribute("LIST_THOIKHOABIEU", thoikhoabieuServices.findAll());
		return "redirect:/thoikhoabieu/list";
	}
}
