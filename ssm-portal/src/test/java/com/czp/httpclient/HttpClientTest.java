package com.czp.httpclient;

import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class HttpClientTest {

	
	@Test
	public void doGet() throws Exception{
		// 创建httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 创建get对象
		HttpGet get = new HttpGet("http://www.baidu.com");
		// 执行请求
		CloseableHttpResponse response = httpClient.execute(get);
		// 取响应的结果
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		HttpEntity entity = response.getEntity();
		String string = EntityUtils.toString(entity,"utf-8");
		System.out.println("读取的内容--->"+string);
		
		// 关闭httpclient
		response.close();
		httpClient.close();
	}
	
	
	@Test
	public void doGetWithParam() throws Exception{
		// 创建httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		//URI uri;
		URIBuilder uriBuilder = new URIBuilder("http://www.sogou.com/web");
		uriBuilder.addParameter("query", "花千骨");
	// 创建get对象
	HttpGet get = new HttpGet(uriBuilder.build());
	// 执行请求
			CloseableHttpResponse response = httpClient.execute(get);
			// 取响应的结果
			int statusCode = response.getStatusLine().getStatusCode();
			System.out.println(statusCode);
			HttpEntity entity = response.getEntity();
			String string = EntityUtils.toString(entity,"utf-8");
			System.out.println("读取的内容--->"+string);
				
				// 关闭httpclient
				response.close();
				httpClient.close();
	}
}
