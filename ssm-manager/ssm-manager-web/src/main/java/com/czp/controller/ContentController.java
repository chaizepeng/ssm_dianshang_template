package com.czp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.czp.common.pojo.AjaxReturnResult;
import com.czp.common.pojo.PageResult;
import com.czp.common.utils.JsonUtils;
import com.czp.pojo.DsContent;
import com.czp.service.ContentService;

@Controller
@RequestMapping("/content")
public class ContentController {

	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/query/list")
	@ResponseBody
	public PageResult getContentList(Integer page,Integer rows,Long categoryId) {
		PageResult contentList = contentService.getContentList(page, rows, categoryId);
		System.out.println("获取到的结果是----->"+JsonUtils.objectToJson(contentList));
		return contentList;
	}
	
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public AjaxReturnResult saveContent(DsContent dsContent) {
		System.out.println("将要添加的数据----->"+JsonUtils.objectToJson(dsContent));
		AjaxReturnResult result = contentService.insertContent(dsContent);
		return result;
	}
	
}
