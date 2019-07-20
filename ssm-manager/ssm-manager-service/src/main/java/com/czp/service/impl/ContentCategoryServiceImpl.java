package com.czp.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.czp.common.pojo.AjaxReturnResult;
import com.czp.common.pojo.TreeNodeResult;
import com.czp.mapper.DsContentCategoryMapper;
import com.czp.pojo.DsContentCategory;
import com.czp.pojo.DsContentCategoryExample;
import com.czp.pojo.DsContentCategoryExample.Criteria;
import com.czp.service.ContentCategoryService;

@Component
public class ContentCategoryServiceImpl implements ContentCategoryService {

	
	@Autowired
	private DsContentCategoryMapper dsContentCategoryMapper;
	
	
	public List<TreeNodeResult> getCategoryList(long parentid) {
		// 根据parentid查询节点列表
		DsContentCategoryExample example = new DsContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentid);
		List<DsContentCategory> list = dsContentCategoryMapper.selectByExample(example);
		
		List<TreeNodeResult> resultList = new ArrayList<TreeNodeResult>();
		for (DsContentCategory dsContentCategory : list) {
			TreeNodeResult node = new TreeNodeResult();
			node.setId(dsContentCategory.getId());
			node.setText(dsContentCategory.getName());
			node.setState(dsContentCategory.getIsParent()?"closed":"open");
			resultList.add(node);
		}
		return resultList;
	}


	/**
	 * 添加内容分类
	 */
	public AjaxReturnResult create(long parentId,String name) {
		DsContentCategory dsContentCategory = new DsContentCategory();
		dsContentCategory.setName(name);
		dsContentCategory.setIsParent(false);
		dsContentCategory.setStatus(1);
		dsContentCategory.setParentId(parentId);
		dsContentCategory.setSortOrder(1);
		dsContentCategory.setCreated(new Date());
		dsContentCategory.setUpdated(new Date());

		// 添加
		dsContentCategoryMapper.insert(dsContentCategory);
		
		// 查看父节点的isParent是否为true，改成true
		DsContentCategory selectByPrimaryKey = dsContentCategoryMapper.selectByPrimaryKey(parentId);
		if (!selectByPrimaryKey.getIsParent()) {
			selectByPrimaryKey.setIsParent(true);
			dsContentCategoryMapper.updateByPrimaryKey(selectByPrimaryKey);
		}
		return AjaxReturnResult.ok(dsContentCategory);
	}


	public AjaxReturnResult delete(Long id) {
		DsContentCategory delCategory = dsContentCategoryMapper.selectByPrimaryKey(id);
		
		deleteCategory(id);
		
		// 判断parentid下边是否还有子节点，没有则换成叶子节点
		DsContentCategoryExample example = new DsContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(delCategory.getParentId());
		List<DsContentCategory> list = dsContentCategoryMapper.selectByExample(example);
		if (list == null || list.size() == 0) {
			DsContentCategory selectByPrimaryKey = dsContentCategoryMapper.selectByPrimaryKey(delCategory.getParentId());
			selectByPrimaryKey.setIsParent(false);
			selectByPrimaryKey.setUpdated(new Date());
			dsContentCategoryMapper.updateByPrimaryKey(selectByPrimaryKey);
		}

		return AjaxReturnResult.ok();
	}


	private void deleteCategory(Long id) {
		DsContentCategory delCategory = dsContentCategoryMapper.selectByPrimaryKey(id);
		dsContentCategoryMapper.deleteByPrimaryKey(id);
		if (delCategory.getIsParent()) { // 还有子节点
			DsContentCategoryExample example = new DsContentCategoryExample();
			Criteria criteria = example.createCriteria();
			criteria.andParentIdEqualTo(delCategory.getId());// 获取到以此节点魏父节点的所有节点
			List<DsContentCategory> list = dsContentCategoryMapper.selectByExample(example);
			if (list != null && list.size() > 0) {
				for (DsContentCategory dsContentCategory : list) {
					deleteCategory(dsContentCategory.getId());
				}
			}
		}
		
	}


	public AjaxReturnResult update(Long id, String name) {
		// 
		DsContentCategory dsContentCategory = dsContentCategoryMapper.selectByPrimaryKey(id);
		dsContentCategory.setName(name);
		dsContentCategory.setUpdated(new Date());
		dsContentCategoryMapper.updateByPrimaryKey(dsContentCategory);
		return AjaxReturnResult.ok();
	}

}
