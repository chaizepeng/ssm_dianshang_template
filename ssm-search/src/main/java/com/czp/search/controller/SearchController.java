package com.czp.search.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.czp.common.pojo.AjaxReturnResult;
import com.czp.common.utils.ExceptionUtil;
import com.czp.search.pojo.SearchResult;
import com.czp.search.service.SearchService;

@Controller
public class SearchController {

	@Autowired
	private SearchService searchService;
	
	@RequestMapping(value="/query", method=RequestMethod.GET)
	@ResponseBody
	public AjaxReturnResult search(@RequestParam("q")String queryString, 
			@RequestParam(defaultValue="1")Integer page, 
			@RequestParam(defaultValue="60")Integer rows) {
		//查询条件不能为空
		if (StringUtils.isBlank(queryString)) {
			return AjaxReturnResult.build(400, "查询条件不能为空");
		}
		SearchResult searchResult = null;
		try {
			// 解决乱码问题
			queryString = new String(queryString.getBytes("iso8859-1"),"utf-8");
			searchResult = searchService.search(queryString, page, rows);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxReturnResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		return AjaxReturnResult.ok(searchResult);
		
	}
	
}
