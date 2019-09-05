package com.czp.rest.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.czp.common.utils.JsonUtils;
import com.czp.mapper.DsContentMapper;
import com.czp.pojo.DsContent;
import com.czp.pojo.DsContentExample;
import com.czp.pojo.DsContentExample.Criteria;
import com.czp.rest.dao.JedisClient;
import com.czp.rest.service.ContentSerevice;


@Component
public class ContentServiceImpl implements ContentSerevice {

	
	@Autowired
	private DsContentMapper dsContentMapper;
	@Autowired
	private JedisClient jedisClient;
	@Value("${INDEX_CONTENT_REDIS_KEY}")
	private String INDEX_CONTENT_REDIS_KEY;
	
	
	/**
	 * 内容获取，先在缓存中获取，如果没有再查询数据库
	 */
	public List<DsContent> getContents(long categoryId) {
		// 从缓存中取
		try {
			String result = jedisClient.hget(INDEX_CONTENT_REDIS_KEY, categoryId+"");
			if (StringUtils.isNotBlank(result)) {
				// string转成list
				List<DsContent> jsonToList = JsonUtils.jsonToList(result, DsContent.class);
				return jsonToList;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 根据内容分类ID查询内容列表
		DsContentExample example = new DsContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(categoryId);
		List<DsContent> list = dsContentMapper.selectByExample(example);
		
		// 缓存中添加内容
		try {
			// 需要先把list转成string
			String cache = JsonUtils.objectToJson(list);
			jedisClient.hset(INDEX_CONTENT_REDIS_KEY, categoryId+"", cache);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
