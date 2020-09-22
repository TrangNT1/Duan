package com.learncode.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learncode.services.GiaovienServices;

@RestController
@RequestMapping(value = "/api")
public class GiaoVienAPI {
	@Autowired
	GiaovienServices giaovienService;
	
	@GetMapping(value = "/giaoviens")
	public Object findGiaoVienByName(@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "page", required = false) Integer page, 
			@RequestParam(name = "limit", required = false) Integer limit) {
		if(null == page) page = 0;
		if(null == limit) limit = 10;
		Pageable pageable = PageRequest.of(page, limit);
		return giaovienService.findGiaovienContainName(name, pageable).getContent();
	}
}
