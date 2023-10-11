package com.poscodx.mysite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poscodx.mysite.service.SiteService;
import com.poscodx.mysite.vo.SiteVo;

@Controller
public class MainController {
	@Autowired
	private SiteService siteService;	
	
	@RequestMapping("/")
	public String index(Model model) {
		SiteVo vo = siteService.getSite();
		
		model.addAttribute("siteVo", vo);
		return "main/index";
	}
	
}
