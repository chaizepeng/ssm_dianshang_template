package com.czp.service;

import com.czp.common.pojo.AjaxReturnResult;
import com.czp.pojo.DsItemParam;

public interface ItemParamService {

	AjaxReturnResult getItemParamByCid(long id);
	AjaxReturnResult insertItemParam(DsItemParam dsItemParam);
}
