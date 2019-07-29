package com.czp.jedis;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

public class JedisTest {

	
	public static void main(String[] args) {
//		new JedisTest().testJedisCluster();
		ApplicationContext applicationContext  = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		JedisCluster jedisCluster = (JedisCluster) applicationContext.getBean("jedisCluster");
		
		jedisCluster.set("name", "zhangsan");
		String value = jedisCluster.get("name");
		System.out.println(value);
	}
	
	/**
	 * 连接池连接单节点redis
	 */
	public void testJedisPool() {
		JedisPool pool = new JedisPool("192.168.1.28",6379);
		Jedis jedis = pool.getResource();
		jedis.auth("123456");
		String string = jedis.get("a");
		
		System.out.println(string);
		jedis.close();
		pool.close();
	}
	
	/**
	 * jedis直接连接单节点redis
	 */
	public void testJedis() {
		Jedis jedis = new Jedis("192.168.1.28", 6379);
		jedis.auth("123456");
		String value = jedis.get("a");
		System.out.println(value);
		jedis.close();
	}
	
	
	/**
	 * 连接redis集群
	 */
	public void testJedisCluster() {
		Set<HostAndPort> nodes = new HashSet<HostAndPort>();
		nodes.add(new HostAndPort("192.168.1.28", 7001));
		nodes.add(new HostAndPort("192.168.1.28", 7002));
		nodes.add(new HostAndPort("192.168.1.28", 7003));
		nodes.add(new HostAndPort("192.168.1.28", 7004));
		nodes.add(new HostAndPort("192.168.1.28", 7005));
		nodes.add(new HostAndPort("192.168.1.28", 7006));
		
		JedisCluster cluster = new JedisCluster(nodes );
		cluster.set("key1", "666");
		String string = cluster.get("key1");
		System.out.println(string);
		cluster.close();
	}
}
