package com.czp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.czp.common.pojo.TreeNodeResult;
import com.czp.common.utils.JsonUtils;
import com.czp.service.ItemCatService;

/**
 * 商品分类管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {

	@Autowired
	private ItemCatService itemCatService;
	
	@RequestMapping("/list")
	@ResponseBody
	public List<TreeNodeResult> getCatList(@RequestParam(value="id",defaultValue="0") Long parentId){
		System.out.println("查询的类目parentid------------>"+parentId);
		List<TreeNodeResult> catList = itemCatService.getCatList(parentId);
		System.out.println("类目信息--->"+JsonUtils.objectToJson(catList));
		return catList;
	}
}
