package com.czp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	@RequestMapping("/{page}")
	public String toPage(@PathVariable String page) {
		System.out.println("go to page "+page);
		return page;
	} 
}
