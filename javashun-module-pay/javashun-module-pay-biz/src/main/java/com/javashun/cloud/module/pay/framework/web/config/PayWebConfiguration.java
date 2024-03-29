package com.javashun.cloud.module.pay.framework.web.config;

import com.javashun.cloud.framework.swagger.config.JavashunSwaggerAutoConfiguration;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * pay 模块的 web 组件的 Configuration
 *
 * @author javashun
 */
@Configuration(proxyBeanMethods = false)
public class PayWebConfiguration {

    /**
     * pay 模块的 API 分组
     */
    @Bean
    public GroupedOpenApi payGroupedOpenApi() {
        return JavashunSwaggerAutoConfiguration.buildGroupedOpenApi("pay");
    }

}
