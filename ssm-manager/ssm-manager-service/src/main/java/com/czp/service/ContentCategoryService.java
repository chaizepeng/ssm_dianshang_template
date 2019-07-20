package com.czp.service;

import java.util.List;

import com.czp.common.pojo.AjaxReturnResult;
import com.czp.common.pojo.TreeNodeResult;
import com.czp.pojo.DsContentCategory;

public interface ContentCategoryService {

	
	public List<TreeNodeResult> getCategoryList(long parentid);

	public AjaxReturnResult create(long parentId,String name);

	public AjaxReturnResult delete(Long parentId);

	public AjaxReturnResult update(Long id, String name);
}
