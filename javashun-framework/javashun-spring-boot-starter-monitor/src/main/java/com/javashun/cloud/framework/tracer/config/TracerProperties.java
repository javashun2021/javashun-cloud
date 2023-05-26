package com.javashun.cloud.framework.tracer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * BizTracer配置类
 */
@ConfigurationProperties("javashun.tracer")
@Data
public class TracerProperties {
}
