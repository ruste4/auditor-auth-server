package ru.te4rus.authserver.repository;

public interface RedisRepository {
    void add(String login, String refreshToken);
    String findByLogin(String login);
}
