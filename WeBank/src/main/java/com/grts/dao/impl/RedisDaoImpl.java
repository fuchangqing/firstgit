package com.grts.dao.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.grts.dao.IRedisDao;

import redis.clients.jedis.JedisPool;
@Repository
public class RedisDaoImpl implements IRedisDao {

	@Resource
	private JedisPool jedisPool;
	
	@Override
	public String get(String key) {
		// TODO Auto-generated method stub
		return jedisPool.getResource().get(key);
	}

	@Override
	public String set(String key, String value) {
		// TODO Auto-generated method stub
		return jedisPool.getResource().set(key, value);
	}

	@Override
	public String hget(String hkey, String key) {
		// TODO Auto-generated method stub
		return jedisPool.getResource().hget(hkey, key);
	}

	@Override
	public long hset(String hkey, String key, String value) {
		// TODO Auto-generated method stub
		return jedisPool.getResource().hset(hkey, key, value);
	}

}
