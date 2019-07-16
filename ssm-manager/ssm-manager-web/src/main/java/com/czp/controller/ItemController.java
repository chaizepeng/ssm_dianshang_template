package com.czp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.czp.common.pojo.AjaxReturnResult;
import com.czp.common.pojo.PageResult;
import com.czp.pojo.DsItem;
import com.czp.service.ItemSerivce;

@Controller
public class ItemController {
	
	@Autowired
	private ItemSerivce itemSerivce;
	
	/**
	 * 商品列表获取
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/item/list")
	@ResponseBody
	public PageResult getItemList(Integer page,Integer rows) {
		return itemSerivce.getItemList(page, rows);
	}
	
	/**
	 * 添加商品
	 * @param item
	 * @param desc
	 * @param itemParams
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/item/save",method=RequestMethod.POST)
	@ResponseBody
	public AjaxReturnResult createItem(DsItem item ,String desc,String itemParams) throws Exception {
		AjaxReturnResult result = itemSerivce.createItem(item,desc,itemParams);
		System.out.println("返回信息"+result);
		return result;
	}
	
}
