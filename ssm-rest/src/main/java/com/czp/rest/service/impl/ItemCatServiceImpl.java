package com.czp.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.czp.mapper.DsItemCatMapper;
import com.czp.pojo.DsItemCat;
import com.czp.pojo.DsItemCatExample;
import com.czp.pojo.DsItemCatExample.Criteria;
import com.czp.rest.pojo.CatNode;
import com.czp.rest.pojo.CatResult;
import com.czp.rest.service.ItemCatService;

@Component
public class ItemCatServiceImpl implements ItemCatService{

	
	@Autowired
	private DsItemCatMapper dsItemCatMapper;
	
	
	public CatResult getItemCatList() {
		
		CatResult catResult = new CatResult();
		// 分类列表添加
		catResult.setData(getCatList(0));
		
		return catResult;
	}

	/**
	 * 递归获取商品分类信息
	 * @param parentId
	 * @return
	 */
	private List<?> getCatList(long parentId) {
		DsItemCatExample example = new DsItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		
		List<DsItemCat> list = dsItemCatMapper.selectByExample(example);
		
		List resultList = new ArrayList<CatNode>();
		int count = 0;
		for (DsItemCat dsItemCat : list) {
			if (dsItemCat.getIsParent()) { // 是父节点
				CatNode catNode = new CatNode();
				if (parentId == 0) {
					catNode.setName("<a href='/products"+dsItemCat.getId()+".html'>"+dsItemCat.getName()+"</a>");
				}else {
					catNode.setName(dsItemCat.getName());
				}
				catNode.setUrl("/products/"+dsItemCat.getId()+".html");
				catNode.setItem(getCatList(dsItemCat.getId()));
				resultList.add(catNode);
				
				count++;
				if (parentId == 0 && count >= 14) {
					break;
				}
			}else { // 叶子节点
				resultList.add("/products/"+dsItemCat.getId()+".html|" + dsItemCat.getName());
			}
			
		}
		return resultList;
	}
}
