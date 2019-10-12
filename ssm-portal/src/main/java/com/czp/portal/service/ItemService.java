package com.czp.portal.service;

import com.czp.pojo.DsItemDesc;
import com.czp.portal.pojo.Item;

public interface ItemService {

	Item getItemById(Long id) throws Exception;
	
	DsItemDesc geTbItemDescById(Long id) throws Exception;
	
	String geTbItemParamItemById(Long id) throws Exception;
}
