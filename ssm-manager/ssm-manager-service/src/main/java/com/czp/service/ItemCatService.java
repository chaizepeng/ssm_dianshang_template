package com.czp.service;

import java.util.List;

import com.czp.common.pojo.TreeNodeResult;

public interface ItemCatService {

	List<TreeNodeResult> getCatList(long parentId);
}
