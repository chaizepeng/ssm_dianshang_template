package com.czp.common.pojo;

import java.util.List;

/**
 * 分页数据对应实体类
 * @author Administrator
 *
 */
public class PageResult {

	private Long total;
	private List<?> rows;
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	
	
}
