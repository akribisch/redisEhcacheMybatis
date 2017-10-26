package com.web.until;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class MybatisCache implements Cache{
	
	private static Logger logger = LoggerFactory.getLogger(MybatisCache.class);
	 
    private Jedis redisClient = createReids();
 
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
 
    private String id;
 
    public MybatisCache(final String id) {
        if (id == null) {
            throw new IllegalArgumentException("Cache instances require an ID");
        }
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>MybatisRedisCache:id=" + id);
        this.id = id;
    }
 
    
    public String getId() {
        return this.id;
    }
 
    
    public int getSize() {
 
        return Integer.valueOf(redisClient.dbSize().toString());
    }
 
    
    public void putObject(Object key, Object value) {
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>putObject:" + key + "=" + value);
        redisClient.set(SerializeUtil.serialize(key.toString()), SerializeUtil.serialize(value));
    }
 
    
    public Object getObject(Object key) {
        Object value = SerializeUtil.unserialize(redisClient.get(SerializeUtil.serialize(key.toString())));
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>getObject:" + key + "=" + value);
        return value;
    }
 
    
    public Object removeObject(Object key) {
        return redisClient.expire(SerializeUtil.serialize(key.toString()), 0);
    }
 
    
    public void clear() {
        redisClient.flushDB();
    }
 
    
    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }
 
    protected static Jedis createReids() {
        @SuppressWarnings("resource")
		JedisPool pool = new JedisPool("127.0.0.1", 6379);
        return pool.getResource();
    }
	
}
