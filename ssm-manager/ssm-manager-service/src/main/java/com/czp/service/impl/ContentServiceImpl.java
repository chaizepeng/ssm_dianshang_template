package com.czp.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.czp.common.pojo.AjaxReturnResult;
import com.czp.common.pojo.PageResult;
import com.czp.mapper.DsContentMapper;
import com.czp.pojo.DsContent;
import com.czp.pojo.DsContentExample;
import com.czp.pojo.DsContentExample.Criteria;
import com.czp.service.ContentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Component
public class ContentServiceImpl implements ContentService{

	
	@Autowired
	private DsContentMapper dsContentMapper;
	public PageResult getContentList(int page, int rows, long categoryId) {
		DsContentExample example = new DsContentExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andCategoryIdEqualTo(categoryId);
		PageHelper.startPage(page, rows);
		List<DsContent> list = dsContentMapper.selectByExample(example);
		PageResult result = new PageResult();
		result.setRows(list);
		result.setTotal(new PageInfo<DsContent>(list).getTotal());
		return result;
	}
	
	
	public AjaxReturnResult insertContent(DsContent dsContent) {
		dsContent.setCreated(new Date());
		dsContent.setUpdated(new Date());
		int insert = dsContentMapper.insert(dsContent);
		if (insert > 0) {
			System.out.println("添加content成功了");
		}
		return AjaxReturnResult.ok(dsContent);
	}


	

}
