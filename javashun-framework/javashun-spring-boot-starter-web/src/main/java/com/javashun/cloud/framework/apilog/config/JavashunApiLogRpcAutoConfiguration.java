package com.javashun.cloud.framework.apilog.config;

import com.javashun.cloud.module.infra.api.logger.ApiAccessLogApi;
import com.javashun.cloud.module.infra.api.logger.ApiErrorLogApi;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * API 日志使用到 Feign 的配置项
 *
 * @author javashun
 */
@AutoConfiguration
@EnableFeignClients(clients = {ApiAccessLogApi.class, // 主要是引入相关的 API 服务
        ApiErrorLogApi.class})
public class JavashunApiLogRpcAutoConfiguration {
}
