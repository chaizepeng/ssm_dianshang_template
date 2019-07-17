package com.czp.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.czp.common.utils.JsonUtils;
import com.czp.rest.pojo.CatResult;
import com.czp.rest.service.ItemCatService;

@Controller
public class ItemCatController {

	
	@Autowired
	private ItemCatService itemCatService;
	
	
	/*@RequestMapping(value="/itemcat/list",produces=MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
	@ResponseBody
	public String getItemCatList(String callback) {
		CatResult result = itemCatService.getItemCatList();
		String json = JsonUtils.objectToJson(result);
		json = callback +"(" +json +");";
		System.out.println("商品分类返回的json数据:"+json);
		return json;
	}*/
	
	@RequestMapping(value="/itemcat/list")
	@ResponseBody
	public Object getItemCatList(String callback) {
		CatResult result = itemCatService.getItemCatList();
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
		mappingJacksonValue.setJsonpFunction(callback);
		return mappingJacksonValue;
	}
}
