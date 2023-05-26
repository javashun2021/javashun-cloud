package com.javashun.cloud.framework.file.config;

import com.javashun.cloud.framework.file.core.client.FileClientFactory;
import com.javashun.cloud.framework.file.core.client.FileClientFactoryImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * 文件配置类
 */
@AutoConfiguration
public class JavashunFileAutoConfiguration {

    @Bean
    public FileClientFactory fileClientFactory() {
        return new FileClientFactoryImpl();
    }

}
