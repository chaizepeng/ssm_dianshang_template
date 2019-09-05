package com.czp.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.czp.common.pojo.AjaxReturnResult;
import com.czp.common.pojo.PageResult;
import com.czp.common.utils.HttpClientUtil;
import com.czp.mapper.DsContentMapper;
import com.czp.pojo.DsContent;
import com.czp.pojo.DsContentExample;
import com.czp.pojo.DsContentExample.Criteria;
import com.czp.service.ContentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 内容服务
 * @author 13979
 *
 */
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
	
	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;

	@Value("${REST_CONTENT_SYNC_URL}")
	private String REST_CONTENT_SYNC_URL;
	/**
	 * 添加内容
	 */
	public AjaxReturnResult insertContent(DsContent dsContent) {
		dsContent.setCreated(new Date());
		dsContent.setUpdated(new Date());
		int insert = dsContentMapper.insert(dsContent);
		
		// 添加缓存同步
		try {
			HttpClientUtil.doGet(REST_BASE_URL + REST_CONTENT_SYNC_URL + dsContent.getCategoryId());
		} catch (Exception e) {
			e.printStackTrace();
			// 通知i，缓存同步失败
		}
		return AjaxReturnResult.ok(dsContent);
	}


	

}
