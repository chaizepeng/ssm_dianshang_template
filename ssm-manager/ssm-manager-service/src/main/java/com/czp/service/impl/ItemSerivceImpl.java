package com.czp.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czp.common.pojo.AjaxReturnResult;
import com.czp.common.pojo.PageResult;
import com.czp.common.utils.IDUtils;
import com.czp.mapper.DsItemDescMapper;
import com.czp.mapper.DsItemMapper;
import com.czp.mapper.DsItemParamItemMapper;
import com.czp.mapper.DsItemParamMapper;
import com.czp.pojo.DsItem;
import com.czp.pojo.DsItemDesc;
import com.czp.pojo.DsItemExample;
import com.czp.pojo.DsItemParam;
import com.czp.pojo.DsItemParamItem;
import com.czp.service.ItemSerivce;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ItemSerivceImpl implements ItemSerivce {

	
	@Autowired
	DsItemMapper dsItemMapper;
	@Autowired
	DsItemDescMapper dsItemDescMapper;
	@Autowired
	DsItemParamItemMapper dsItemParamItemMapper;
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

	/**
	 * 添加商品信息
	 * @throws Exception 
	 */
	public AjaxReturnResult createItem(DsItem dsItem,String desc,String itemParams) throws Exception {
		// 字段补全
		dsItem.setId(IDUtils.getItemId());
		// 1 正常 2 下架 3 删除
		dsItem.setStatus((byte)1);
		dsItem.setCreated(new Date());
		dsItem.setUpdated(new Date());
		
		// 添加到数据库
		dsItemMapper.insert(dsItem);
		boolean flag = insertDesc(desc, dsItem.getId());
		if (!flag) {
			throw new Exception("添加商品描述出错");
		}
		boolean flag2 = insertItemParams(dsItem.getId(), itemParams);
		if (!flag2) {
			throw new Exception("添加商品描述出错");
		}
		return AjaxReturnResult.ok();
	}
	
	private boolean insertDesc(String desc , Long id) {
		DsItemDesc dsItemDesc = new DsItemDesc();
		dsItemDesc.setItemId(id);
		dsItemDesc.setItemDesc(desc);
		dsItemDesc.setUpdated(new Date());
		dsItemDesc.setCreated(new Date());
		int insert = dsItemDescMapper.insert(dsItemDesc);
		return insert > 0;
	}
	
	private boolean insertItemParams(Long itemId , String itemParams) {
		DsItemParamItem dsItemParamItem = new DsItemParamItem();
		dsItemParamItem.setItemId(itemId);
		dsItemParamItem.setParamData(itemParams);
		dsItemParamItem.setCreated(new Date());
		dsItemParamItem.setUpdated(new Date());
		
		int insert = dsItemParamItemMapper.insert(dsItemParamItem);
		return insert>0;
	}

}
