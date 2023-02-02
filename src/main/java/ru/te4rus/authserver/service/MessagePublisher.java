package ru.te4rus.authserver.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessagePublisher {
    private final RedisTemplate<String, Object> redisTemplate;
    private final ChannelTopic topic;

    public void publish(final String message) {
        redisTemplate.convertAndSend(topic.getTopic(), message);
    }
}
