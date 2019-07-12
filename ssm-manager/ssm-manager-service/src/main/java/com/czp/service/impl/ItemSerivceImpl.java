package com.czp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czp.common.pojo.PageResult;
import com.czp.mapper.DsItemMapper;
import com.czp.pojo.DsItem;
import com.czp.pojo.DsItemExample;
import com.czp.service.ItemSerivce;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ItemSerivceImpl implements ItemSerivce {

	
	@Autowired
	DsItemMapper dsItemMapper;
	public DsItem getItemById(Long itemId) {
		// TODO Auto-generated method stub
		return dsItemMapper.selectByPrimaryKey(itemId);
	}
	
	/**
	 * 商品列表
	 */
	public PageResult getItemList(int page, int rows) {
		DsItemExample example = new DsItemExample();
		PageHelper.startPage(page, rows);
		List<DsItem> list = dsItemMapper.selectByExample(example);
		PageResult result = new PageResult();
		result.setRows(list);
		result.setTotal(new PageInfo<DsItem>(list).getTotal());
		return result;
	}

}
