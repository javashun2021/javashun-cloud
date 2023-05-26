package com.javashun.cloud.framework.sms.config;

import com.javashun.cloud.framework.sms.core.client.SmsClientFactory;
import com.javashun.cloud.framework.sms.core.client.impl.SmsClientFactoryImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * 短信配置类
 */
@AutoConfiguration
public class JavashunSmsAutoConfiguration {

    @Bean
    public SmsClientFactory smsClientFactory() {
        return new SmsClientFactoryImpl();
    }

}
