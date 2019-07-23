package com.czp.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.czp.common.pojo.AjaxReturnResult;
import com.czp.common.utils.ExceptionUtil;
import com.czp.pojo.DsContent;
import com.czp.rest.service.ContentSerevice;

@Controller
@RequestMapping("/content")
public class ContentController {

	
	@Autowired
	private ContentSerevice contentSerevice;
	
	@RequestMapping("/list/{contentCategoryId}")
	@ResponseBody
	public AjaxReturnResult getContentLlist(@PathVariable Long contentCategoryId) {
		try {
			List<DsContent> list = contentSerevice.getContents(contentCategoryId);
			return AjaxReturnResult.ok(list);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxReturnResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
}
