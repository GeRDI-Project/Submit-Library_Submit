package org.gerdi.submit.config;

import org.gerdi.submit.model.progress.Progress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@EnableRedisRepositories
@Configuration
public class RedisConfiguration {

    @Value("${GERDI_REDIS_HOSTNAME}")
    private String redisHostname;

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration(redisHostname);
        return new JedisConnectionFactory(config);
    }

    @Bean
    public RedisTemplate<String, Progress> redisTemplate() {
        RedisTemplate<String, Progress> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }

}
