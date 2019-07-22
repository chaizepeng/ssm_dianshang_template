package com.czp.service;

import com.czp.common.pojo.AjaxReturnResult;
import com.czp.common.pojo.PageResult;
import com.czp.pojo.DsContent;

public interface ContentService {

	PageResult getContentList(int page,int rows,long categoryId);

	AjaxReturnResult insertContent(DsContent dsContent);
}
