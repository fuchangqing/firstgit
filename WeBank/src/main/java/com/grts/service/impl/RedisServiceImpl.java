package com.grts.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.grts.dao.IRedisDao;
import com.grts.service.IRedisService;
@Service
public class RedisServiceImpl implements IRedisService {

	@Resource
	private IRedisDao dao;
	@Override
	public String get(String key) {
		// TODO Auto-generated method stub
		return dao.get(key);
	}

	@Override
	public String set(String key, String value) {
		// TODO Auto-generated method stub
		return dao.set(key, value);
	}

	@Override
	public String hget(String hkey, String key) {
		// TODO Auto-generated method stub
		return dao.hget(hkey, key);
	}

	@Override
	public long hset(String hkey, String key, String value) {
		// TODO Auto-generated method stub
		return dao.hset(hkey, key, value);
	}

	
}
