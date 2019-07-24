package com.czp.portal.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.czp.common.pojo.AjaxReturnResult;
import com.czp.common.utils.HttpClientUtil;
import com.czp.common.utils.JsonUtils;
import com.czp.pojo.DsContent;
import com.czp.portal.service.ContentService;
import java.util.Map;


/**
 * 调用服务曾，查询产品列表
 * @author Administrator
 *
 */
@Component
public class ContentServiceImpl implements ContentService{

	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	@Value("${REST_INDEX_AD_URL}")
	private String REST_INDEX_AD_URL;
	
	public String getContentList() {
		String result = HttpClientUtil.doGet(REST_BASE_URL + REST_INDEX_AD_URL);
		try {
			// 把这个字符串专程AjaxResult
			AjaxReturnResult ajaxReturnResult = AjaxReturnResult.formatToList(result, DsContent.class);
			List<DsContent> list = (List<DsContent>)ajaxReturnResult.getData();
			
			List<Map> resultList = new ArrayList<Map>();
			for (DsContent content : list) {
				Map map = new HashMap();
				map.put("src", content.getPic());
				map.put("height", 240);
				map.put("width", 670);
				map.put("srcB", content.getPic2());
				map.put("widthB", 550);
				map.put("heightB", 240);
				map.put("href", content.getUrl());
				map.put("alt", content.getSubTitle());
				resultList.add(map);
			}
			return JsonUtils.objectToJson(resultList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	

	
	
}
