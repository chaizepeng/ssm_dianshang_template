package com.czp.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.czp.common.pojo.AjaxReturnResult;
import com.czp.common.utils.ExceptionUtil;
import com.czp.rest.dao.JedisClient;
import com.czp.rest.service.RedisService;

@Service
public class RedisServiceImpl implements RedisService {

	
	@Autowired
	private JedisClient jedisClient;
	@Value("${INDEX_CONTENT_REDIS_KEY}")
	private String INDEX_CONTENT_REDIS_KEY;
	
	/**
	 * 同步数据库中数据
	 */
	public AjaxReturnResult syncContent(long contentId) {
		try {
			jedisClient.hdel(INDEX_CONTENT_REDIS_KEY, contentId + "");
		} catch (Exception e) {
			return  AjaxReturnResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		return AjaxReturnResult.ok();
	}

}
