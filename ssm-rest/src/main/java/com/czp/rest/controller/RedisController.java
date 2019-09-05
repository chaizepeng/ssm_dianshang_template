package com.czp.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.czp.common.pojo.AjaxReturnResult;
import com.czp.rest.service.RedisService;

@Controller
@RequestMapping("/cache/sync")
public class RedisController {

	
	@Autowired
	private RedisService redisService;
	
	@RequestMapping("content/{contentCid}")
	@ResponseBody
	public AjaxReturnResult contentCacheSync(@PathVariable Long contentCid) {
		AjaxReturnResult result = redisService.syncContent(contentCid);
		return result;
	}
	
}
