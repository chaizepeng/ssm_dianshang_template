package com.czp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.czp.common.pojo.PageResult;
import com.czp.pojo.DsItem;
import com.czp.service.ItemSerivce;

@Controller
//@RequestMapping("/ItemController")
public class ItemController {

	
	@Autowired
	private ItemSerivce itemSerivce;
	
//	@RequestMapping("/item/{itemId}")
//	@ResponseBody
//	public DsItem getItemById(@PathVariable Long itemId) {
//		return itemSerivce.getItemById(itemId);
//	}
	
	@RequestMapping("/item/list")
	@ResponseBody
	public PageResult getItemList(Integer page,Integer rows) {
		return itemSerivce.getItemList(page, rows);
	}
	
}
