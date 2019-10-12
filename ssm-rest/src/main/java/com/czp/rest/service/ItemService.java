package com.czp.rest.service;

import com.czp.pojo.DsItem;
import com.czp.pojo.DsItemDesc;
import com.czp.pojo.DsItemParamItem;

public interface ItemService {

	/**
	 * 根据id取商品信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	DsItem getItemById(Long id) throws Exception;
	
	/**
	 * 根据id取商品描述
	 * @param id
	 * @return
	 * @throws Exception
	 */
	DsItemDesc getItemDescById(Long id) throws Exception;
	
	/**
	 * 根据商品id取规格参数
	 * @param id
	 * @return
	 * @throws Exception
	 */
	DsItemParamItem getItemParamById(Long id) throws Exception;
}
