package com.czp.rest.service;

import java.util.List;

import com.czp.pojo.DsContent;

public interface ContentSerevice {

	List<DsContent> getContents(long categoryId);
}
