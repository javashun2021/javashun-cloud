package com.javashun.cloud.framework.idempotent.config;

import com.javashun.cloud.framework.idempotent.core.aop.IdempotentAspect;
import com.javashun.cloud.framework.idempotent.core.keyresolver.IdempotentKeyResolver;
import com.javashun.cloud.framework.idempotent.core.keyresolver.impl.DefaultIdempotentKeyResolver;
import com.javashun.cloud.framework.idempotent.core.keyresolver.impl.ExpressionIdempotentKeyResolver;
import com.javashun.cloud.framework.idempotent.core.redis.IdempotentRedisDAO;
import com.javashun.cloud.framework.redis.config.JavashunRedisAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;

@AutoConfiguration
@AutoConfigureAfter(JavashunRedisAutoConfiguration.class)
public class JavashunIdempotentConfiguration {

    @Bean
    public IdempotentAspect idempotentAspect(List<IdempotentKeyResolver> keyResolvers, IdempotentRedisDAO idempotentRedisDAO) {
        return new IdempotentAspect(keyResolvers, idempotentRedisDAO);
    }

    @Bean
    public IdempotentRedisDAO idempotentRedisDAO(StringRedisTemplate stringRedisTemplate) {
        return new IdempotentRedisDAO(stringRedisTemplate);
    }

    // ========== 各种 IdempotentKeyResolver Bean ==========

    @Bean
    public DefaultIdempotentKeyResolver defaultIdempotentKeyResolver() {
        return new DefaultIdempotentKeyResolver();
    }

    @Bean
    public ExpressionIdempotentKeyResolver expressionIdempotentKeyResolver() {
        return new ExpressionIdempotentKeyResolver();
    }

}
