package ru.te4rus.authserver.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public class RefreshTokenRepository implements RedisRepository {

    private static final String KEY = "RefreshToken";
    private final RedisTemplate<String, Object> redisTemplate;
    private HashOperations<String, String, String> hashOperations;

    @Autowired
    public RefreshTokenRepository(RedisTemplate<String, Object> redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init(){
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void add(String login, String refreshToken) {
        hashOperations.put(KEY, login, refreshToken);
    }

    @Override
    public String findByLogin(String login) {
        return hashOperations.get(KEY, login);
    }
}
