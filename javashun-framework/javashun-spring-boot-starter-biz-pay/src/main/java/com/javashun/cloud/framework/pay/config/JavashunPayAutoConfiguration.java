package com.javashun.cloud.framework.pay.config;

import com.javashun.cloud.framework.pay.core.client.PayClientFactory;
import com.javashun.cloud.framework.pay.core.client.impl.PayClientFactoryImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * 支付配置类
 *
 * @author javashun
 */
@AutoConfiguration
public class JavashunPayAutoConfiguration {

    @Bean
    public PayClientFactory payClientFactory() {
        return new PayClientFactoryImpl();
    }

}
