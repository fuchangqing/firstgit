package com.grts.service;

public interface IRedisService {
	public String get(String key);

	public String set(String key, String value);

	public String hget(String hkey, String key);

	public long hset(String hkey, String key, String value);
}
