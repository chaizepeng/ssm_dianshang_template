package com.czp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/toIndex")
	public String toIndex() {
		return "index";
	}
}
