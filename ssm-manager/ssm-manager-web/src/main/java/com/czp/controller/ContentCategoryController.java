package com.czp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.czp.common.pojo.AjaxReturnResult;
import com.czp.common.pojo.TreeNodeResult;
import com.czp.common.utils.JsonUtils;
import com.czp.pojo.DsContentCategory;
import com.czp.service.ContentCategoryService;

/**
 * 内容分类管理控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {

	@Autowired
	private ContentCategoryService contentCategoryService;
	
	@RequestMapping("/list")
	@ResponseBody
	public List<TreeNodeResult> getContentCategoryList(@RequestParam(value="id",defaultValue="0")Long parentId) {
		List<TreeNodeResult> categoryList = contentCategoryService.getCategoryList(parentId);
		String json = JsonUtils.objectToJson(categoryList);
		System.out.println("返回的数据-->"+json);
		return categoryList;
	}
	
	@RequestMapping("/create")
	@ResponseBody
	public AjaxReturnResult create(Long parentId,String name) {
		AjaxReturnResult result = contentCategoryService.create(parentId,name);
		return result;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxReturnResult delete(Long id) {
		System.out.println("删除的信息-->--->"+id);
		// 直接物理删除
		AjaxReturnResult result = contentCategoryService.delete(id);
		return result;
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public AjaxReturnResult update(Long id, String name) {
		AjaxReturnResult result = contentCategoryService.update(id,name);
		return result;
	}
}
