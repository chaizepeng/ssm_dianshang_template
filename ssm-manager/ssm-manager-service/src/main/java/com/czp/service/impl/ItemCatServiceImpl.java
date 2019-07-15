package com.czp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.czp.common.pojo.TreeNodeResult;
import com.czp.mapper.DsItemCatMapper;
import com.czp.pojo.DsItemCat;
import com.czp.pojo.DsItemCatExample;
import com.czp.pojo.DsItemCatExample.Criteria;
import com.czp.service.ItemCatService;

@Component
public class ItemCatServiceImpl implements ItemCatService{

	@Autowired
	DsItemCatMapper dsItemCatMapper;
	
	public List<TreeNodeResult> getCatList(long parentId) {
		
		// 创建查询条件
		DsItemCatExample example = new DsItemCatExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andParentIdEqualTo(parentId);
		// 根据条件查询
		List<DsItemCat> list = dsItemCatMapper.selectByExample(example);
		// 把列表数据专成treenodelist
		List<TreeNodeResult> resultList = new ArrayList<TreeNodeResult>();
		for (DsItemCat dsItemCat : list) {
			TreeNodeResult result = new TreeNodeResult();
			result.setId(dsItemCat.getId());
			result.setText(dsItemCat.getName());
			result.setState(dsItemCat.getIsParent()?"closed":"open");
			resultList.add(result);
		}
		
		return resultList;
	}

}
