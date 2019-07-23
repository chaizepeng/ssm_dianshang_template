package com.czp.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.czp.mapper.DsContentMapper;
import com.czp.pojo.DsContent;
import com.czp.pojo.DsContentExample;
import com.czp.pojo.DsContentExample.Criteria;
import com.czp.rest.service.ContentSerevice;


@Component
public class ContentServiceImpl implements ContentSerevice {

	
	@Autowired
	private DsContentMapper dsContentMapper;
	
	public List<DsContent> getContents(long categoryId) {
		// 根据内容分类ID查询内容列表
		DsContentExample example = new DsContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(categoryId);
		List<DsContent> list = dsContentMapper.selectByExample(example);
		return list;
	}

}
