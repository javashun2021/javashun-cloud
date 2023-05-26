package com.javashun.cloud.framework.operatelog.config;

import com.javashun.cloud.framework.operatelog.core.aop.OperateLogAspect;
import com.javashun.cloud.framework.operatelog.core.service.OperateLogFrameworkService;
import com.javashun.cloud.framework.operatelog.core.service.OperateLogFrameworkServiceImpl;
import com.javashun.cloud.module.system.api.logger.OperateLogApi;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class JavashunOperateLogAutoConfiguration {

    @Bean
    public OperateLogAspect operateLogAspect() {
        return new OperateLogAspect();
    }

    @Bean
    public OperateLogFrameworkService operateLogFrameworkService(OperateLogApi operateLogApi) {
        return new OperateLogFrameworkServiceImpl(operateLogApi);
    }

}
