package com.czp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czp.mapper.DsItemMapper;
import com.czp.pojo.DsItem;
import com.czp.service.ItemSerivce;

@Service
public class ItemSerivceImpl implements ItemSerivce {

	
	@Autowired
	DsItemMapper dsItemMapper;
	public DsItem getItemById(Long itemId) {
		// TODO Auto-generated method stub
		return dsItemMapper.selectByPrimaryKey(itemId);
	}

}
