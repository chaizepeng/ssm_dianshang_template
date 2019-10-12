package com.czp.rest.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.czp.common.utils.JsonUtils;
import com.czp.pojo.DsItem;
import com.czp.pojo.DsItemDesc;
import com.czp.pojo.DsItemParamItem;
import com.czp.pojo.DsItemParamItemExample;
import com.czp.pojo.DsItemParamItemExample.Criteria;
import com.czp.rest.mapper.DsItemDescMapper;
import com.czp.rest.mapper.DsItemMapper;
import com.czp.rest.mapper.DsItemParamItemMapper;
import com.czp.rest.service.ItemService;

import redis.clients.jedis.JedisCluster;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private DsItemMapper dsItemMapper;
	@Autowired
	private DsItemDescMapper itemDescMapper;
	@Autowired
	private DsItemParamItemMapper dsItemParamItemMapper;
	@Autowired
	private JedisCluster jedisCluster;

	@Value("${REDIS_ITEM_KEY}")
	private String REDIS_ITEM_KEY;
	@Value("${REDIS_ITEM_EXPIRE}")
	private Integer REDIS_ITEM_EXPIRE;

	public DsItem getItemById(Long id) throws Exception {
		// 缓存中命中
		// 在redis中无法对hash中的可以做expire。所以使用另外一种方法：key的命名方法为“主key：id”
		String itemCache = jedisCluster.get(REDIS_ITEM_KEY + ":" + id);
		try {
			if (!StringUtils.isBlank(itemCache)) {
				DsItem dsItem = JsonUtils.jsonToPojo(itemCache, DsItem.class);
				return dsItem;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		DsItem dsItem = dsItemMapper.selectByPrimaryKey(id);
		// 把数据缓存起来
		try {
			jedisCluster.set(REDIS_ITEM_KEY + ":" + id, JsonUtils.objectToJson(dsItem));
			// 设置过期时间，有效期一天
			jedisCluster.expire(REDIS_ITEM_KEY + ":" + id, 60 * 60 * 24);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsItem;
	}

	public DsItemDesc getItemDescById(Long id) throws Exception {
		DsItemDesc dsItemDesc = itemDescMapper.selectByPrimaryKey(id);
		return dsItemDesc;
	}

	public DsItemParamItem getItemParamById(Long id) throws Exception {
		DsItemParamItemExample example = new DsItemParamItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andItemIdEqualTo(id);
		List<DsItemParamItem> list = dsItemParamItemMapper.selectByExampleWithBLOBs(example);
		DsItemParamItem dsItemParamItem = null;
		if (list != null && !list.isEmpty()) {
			dsItemParamItem = list.get(0);
		}
		return dsItemParamItem;
	}

}
