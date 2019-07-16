package com.czp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.czp.common.pojo.AjaxReturnResult;
import com.czp.common.utils.JsonUtils;
import com.czp.pojo.DsItemParam;
import com.czp.service.ItemParamService;

/**
 * 商品规格模板管理
 * @author 13979
 *
 */
@Controller
@RequestMapping("/item/param")
public class ItemParamController {

	
	@Autowired
	private ItemParamService itemParamService;
	
	
	@RequestMapping("/query/itemcatid/{itemCatId}")
	@ResponseBody
	public AjaxReturnResult getItemParamByCid(@PathVariable Long itemCatId) {
		AjaxReturnResult result = itemParamService.getItemParamByCid(itemCatId);
		System.out.println("规格模板信息------->"+JsonUtils.objectToJson(result));
		return result;
	}
	
	@RequestMapping("/save/{cid}")
	@ResponseBody
	public AjaxReturnResult insertItemParam(@PathVariable Long cid,String paramData) {
		DsItemParam dsItemParam = new DsItemParam();
		dsItemParam.setItemCatId(cid);
		dsItemParam.setParamData(paramData);
		AjaxReturnResult result = itemParamService.insertItemParam(dsItemParam);
		System.out.println("添加的商品规格信息--------->"+JsonUtils.objectToJson(result));
		return result;
	}
}
