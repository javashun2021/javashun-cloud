package com.javashun.cloud.framework.tenant.config;

import com.javashun.cloud.framework.tenant.core.mq.TenantChannelInterceptor;
import com.javashun.cloud.framework.tenant.core.mq.TenantFunctionAroundWrapper;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.function.context.catalog.FunctionAroundWrapper;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.config.GlobalChannelInterceptor;

@AutoConfiguration
@ConditionalOnProperty(prefix = "javashun.tenant", value = "enable", matchIfMissing = true) // 允许使用 javashun.tenant.enable=false 禁用多租户
@ConditionalOnClass(name = {
        "org.springframework.messaging.support.ChannelInterceptor",
        "org.springframework.cloud.function.context.catalog.FunctionAroundWrapper"
})
@EnableConfigurationProperties(TenantProperties.class)
public class JavashunTenantMQAutoConfiguration {

    @Bean
    @GlobalChannelInterceptor // 必须添加在方法上，否则无法生效
    public TenantChannelInterceptor tenantChannelInterceptor() {
        return new TenantChannelInterceptor();
    }

    @Bean
    public FunctionAroundWrapper functionAroundWrapper() {
        return new TenantFunctionAroundWrapper();
    }

}
