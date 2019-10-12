package com.czp.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.czp.common.pojo.AjaxReturnResult;
import com.czp.common.utils.ExceptionUtil;
import com.czp.pojo.DsItem;
import com.czp.pojo.DsItemDesc;
import com.czp.pojo.DsItemParamItem;
import com.czp.rest.service.ItemService;

@Controller
@RequestMapping("/items")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/item/{id}")
	@ResponseBody
	public AjaxReturnResult getItemById(@PathVariable Long id) {
		if (id == null) {
			return AjaxReturnResult.build(400, "参数中必须包含id");
		}
		DsItem dsItem = null;
		try {
			dsItem = itemService.getItemById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxReturnResult.build(500, ExceptionUtil.getStackTrace(e));
			// TODO: handle exception
		}
		return AjaxReturnResult.ok(dsItem);
	}
	
	@RequestMapping("/itemdesc/{id}")
	@ResponseBody
	public AjaxReturnResult getItemDescById(@PathVariable Long id) {
		//有效性验证
		if (id == null) {
			return AjaxReturnResult.build(400, "参数中必须包含id");
		}
		DsItemDesc dsItemDesc = null;
		//根据id查询商品明细信息
		try {
			dsItemDesc = itemService.getItemDescById(id);
		} catch (Exception e) {
			e.printStackTrace();
			//发生异常时返回异常信息
			return AjaxReturnResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		return AjaxReturnResult.ok(dsItemDesc);
	}
	
	
	@RequestMapping("/itemparam/{id}")
	@ResponseBody
	public AjaxReturnResult getItemParamById(@PathVariable Long id) {
		//有效性验证
		if (id == null) {
			return AjaxReturnResult.build(400, "参数中必须包含id");
		}
		DsItemParamItem dsItemParamItem = null;
		//根据id查询商品规格参数信息
		try {
			dsItemParamItem = itemService.getItemParamById(id);
		} catch (Exception e) {
			e.printStackTrace();
			//发生异常时返回异常信息
			return AjaxReturnResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		return AjaxReturnResult.ok(dsItemParamItem);
	}
}
