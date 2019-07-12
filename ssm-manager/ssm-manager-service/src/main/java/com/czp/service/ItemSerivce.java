package com.czp.service;

import com.czp.common.pojo.PageResult;
import com.czp.pojo.DsItem;

public interface ItemSerivce {

	DsItem getItemById(Long itemId);
	
	PageResult getItemList(int page,int rows);
}
