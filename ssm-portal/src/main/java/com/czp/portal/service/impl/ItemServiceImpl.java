package com.czp.portal.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.czp.common.pojo.AjaxReturnResult;
import com.czp.common.utils.HttpClientUtil;
import com.czp.common.utils.JsonUtils;
import com.czp.pojo.DsItemDesc;
import com.czp.pojo.DsItemParamItem;
import com.czp.portal.pojo.Item;
import com.czp.portal.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	@Value("${ITEMS_ITEM_URL}")
	private String ITEMS_ITEM_URL;
	@Value("${ITEMS_ITEMDESC_URL}")
	private String ITEMS_ITEMDESC_URL;
	@Value("${ITEMS_ITEMPARAM_URL}")
	private String ITEMS_ITEMPARAM_URL;

	public Item getItemById(Long id) throws Exception {
		// 查询商品信息
		String result = HttpClientUtil.doGet(REST_BASE_URL + ITEMS_ITEM_URL + id);
		// 转换成java对象
		AjaxReturnResult returnResult = AjaxReturnResult.formatToPojo(result, Item.class);
		Item item = null;
		if (returnResult.getStatus() == 200) {
			item = (Item) returnResult.getData();
		}

		return item;
	}

	public DsItemDesc geTbItemDescById(Long id) throws Exception {
		// 查询商品信息
		String result = HttpClientUtil.doGet(REST_BASE_URL + ITEMS_ITEMDESC_URL + id);
		// 转换成java对象
		AjaxReturnResult returnResult = AjaxReturnResult.formatToPojo(result, DsItemDesc.class);
		DsItemDesc itemDesc = null;
		if (returnResult.getStatus() == 200) {
			itemDesc = (DsItemDesc) returnResult.getData();
		}

		return itemDesc;
	}

	public String geTbItemParamItemById(Long id) throws Exception {
		// 查询商品信息
		String result = HttpClientUtil.doGet(REST_BASE_URL + ITEMS_ITEMPARAM_URL + id);
		// 转换成java对象
		AjaxReturnResult taotaoResult = AjaxReturnResult.formatToPojo(result, DsItemParamItem.class);
		String resultHtml = "";
		if (taotaoResult.getStatus() == 200) {
			try {
				DsItemParamItem itemParamItem = (DsItemParamItem) taotaoResult.getData();
				// 取规格参数信息
				String paramData = itemParamItem.getParamData();
				// 把规格参数转换成java对象
				List<Map> paramList = JsonUtils.jsonToList(paramData, Map.class);
				// 拼装html
				resultHtml = "<table cellpadding=\"0\" cellspacing=\"1\" width=\"100%\" border=\"0\" class=\"Ptable\">\n"
						+ "    <tbody>\n";
				for (Map map : paramList) {
					resultHtml += "        <tr>\n" + "            <th class=\"tdTitle\" colspan=\"2\">"
							+ map.get("group") + "</th>\n" + "        </tr>\n";
					List<Map> params = (List<Map>) map.get("params");
					for (Map map2 : params) {

						resultHtml += "        <tr>\n" + "            <td class=\"tdTitle\">" + map2.get("k")
								+ "</td>\n" + "            <td>" + map2.get("v") + "</td>\n" + "        </tr>\n";
					}

				}
				resultHtml += "    </tbody>\n" + "</table>";
			} catch (Exception e) {
				// 如果转换发送异常，忽略。返回一个空字符串。
				e.printStackTrace();
			}
		}

		return resultHtml;
	}

}
