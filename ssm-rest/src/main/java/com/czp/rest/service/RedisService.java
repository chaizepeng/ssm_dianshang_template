package com.czp.rest.service;

import com.czp.common.pojo.AjaxReturnResult;

public interface RedisService {

	
	AjaxReturnResult syncContent(long contentId);
}
