package com.czp.search.service;

import com.czp.search.pojo.SearchResult;

public interface SearchService {

	public SearchResult search(String queryString, int page, int rows) throws Exception;
}
