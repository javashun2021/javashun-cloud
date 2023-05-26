package com.javashun.cloud.framework.pay.config;

import com.javashun.cloud.framework.pay.core.client.PayClientFactory;
import com.javashun.cloud.framework.pay.core.client.impl.PayClientFactoryImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * 支付配置类
 *
 * @author javashun
 */
@AutoConfiguration
@EnableConfigurationProperties(PayProperties.class)
public class JavashunPayAutoConfiguration {

    @Bean
    public PayClientFactory payClientFactory() {
        return new PayClientFactoryImpl();
    }

}
