package com.learncode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LayoutController {
	@RequestMapping("/")
	public String show() {
		return "layout/main-layout";
	}
	
}
