package com.czp.controller;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.czp.mapper.DsItemMapper;
import com.czp.pojo.DsItem;
import com.czp.pojo.DsItemExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class TestPageHelper {

	@Test
	public void testPageHelper(){
		// 创建spring容器
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		// 在spring容器中获取mapper代理对象
		DsItemMapper dsItemMapper = applicationContext.getBean(DsItemMapper.class);
		//
		DsItemExample example = new DsItemExample();
		// 分页处理
		PageHelper.startPage(1, 10);
		List<DsItem> list = dsItemMapper.selectByExample(example);
		//获取商品列表
		for (DsItem dsItem : list) {
			System.out.println(dsItem.getTitle());
		}
		// 取分页信息
		PageInfo<DsItem> pageInfo = new PageInfo<DsItem>(list);
		long total = pageInfo.getTotal();
		System.out.println("共有记录数--->"+total);
	}
}
