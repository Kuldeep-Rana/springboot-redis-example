package com.spring.redis.repo;

import com.spring.redis.intfc.Cacheable;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class RedisCacheRepository {
    private RedisTemplate<String, Cacheable> redisTemplate;
    HashOperations<String, Object, Object> hashOperations;

    public RedisCacheRepository(RedisTemplate<String, Cacheable> redisTemplate) {
        this.redisTemplate =redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }

    public void saveOrUpdate(String db, Object key, Cacheable value) {
        hashOperations.put(db, key, value);
    }

    public Cacheable getById(String db, Object key) {
        return (Cacheable) hashOperations.get(db, key);
    }

    public Map<Object, Object> getAll(String db) {
        return hashOperations.entries(db);
    }

    public void delete(String db, Object Id) {
        hashOperations.delete(db, Id);
    }
}
