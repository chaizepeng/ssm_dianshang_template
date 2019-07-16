package com.czp.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.czp.common.pojo.AjaxReturnResult;
import com.czp.mapper.DsItemParamMapper;
import com.czp.pojo.DsItemParam;
import com.czp.pojo.DsItemParamExample;
import com.czp.pojo.DsItemParamExample.Criteria;
import com.czp.service.ItemParamService;

@Component
public class ItemParamServiceImpl implements ItemParamService{

	
	@Autowired
	private DsItemParamMapper dsItemParamMapper;
	
	public AjaxReturnResult getItemParamByCid(long id) {
		DsItemParamExample example = new DsItemParamExample();
		Criteria criteria = example.createCriteria();
		criteria.andItemCatIdEqualTo(id);
		List<DsItemParam> list = dsItemParamMapper.selectByExampleWithBLOBs(example);
		if (list != null && list.size() > 0) {
			return AjaxReturnResult.ok(list.get(0));
		}
		return AjaxReturnResult.ok();
	}

	/**
	 * 添加商品规格模板
	 */
	public AjaxReturnResult insertItemParam(DsItemParam dsItemParam) {
		dsItemParam.setCreated(new Date());
		dsItemParam.setUpdated(new Date());
		dsItemParamMapper.insert(dsItemParam);
		return AjaxReturnResult.ok();
	}

}
