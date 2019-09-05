package com.czp.rest.dao;

public interface JedisClient {

	String get(String key);
	
	String set(String key,String value);
	
	String hget(String hkey,String key);
	
	long hset(String hkey,String key ,String value);
	
	long incr(String key);
	
	// 设置过期时间
	long expire(String key,int second);
	
	// 查看key的到期时间还剩多少
	long ttl(String key); 
	// expire a 1000  设置key为a的过期时间为1000 秒
	// ttl a 来查看a的值还有多长时间过期
	// 返回-2 表示key已经被删掉
	
	//删除
	long del(String key);
	
	long hdel(String hkey,String key);
}
