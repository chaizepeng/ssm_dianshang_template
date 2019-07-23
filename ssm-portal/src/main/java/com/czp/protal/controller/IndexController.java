package com.czp.protal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.czp.common.pojo.AjaxReturnResult;

@Controller
public class IndexController {

	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="/httpclient/post", method=RequestMethod.POST)
	@ResponseBody
	public String testPost(String name,String password) {
		return "name:"+name+",password:"+password;
	}
}
