package com.czp.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.czp.portal.service.ContentService;

@Controller
public class IndexController {

	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/index")
	public String index(Model model) {
		String json = contentService.getContentList();
		System.out.println("首页banner信息---->"+json);
		model.addAttribute("ad1", json);
		return "index";
	}
	
	@RequestMapping(value="/httpclient/post", method=RequestMethod.POST,produces=MediaType.TEXT_PLAIN_VALUE+";charset=utf-8")
	@ResponseBody
	public String testPost(String name,String password) {
		return "name:"+name+",password:"+password;
	}
}
