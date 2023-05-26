package com.javashun.cloud.module.system.mq.consumer.dept;

import com.javashun.cloud.module.system.mq.message.dept.DeptRefreshMessage;
import com.javashun.cloud.module.system.service.dept.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 针对 {@link DeptRefreshMessage} 的消费者
 */
@Component
@Slf4j
public class DeptRefreshConsumer {

    @Resource
    private DeptService deptService;

    @EventListener
    public void execute(DeptRefreshMessage message) {
        log.info("[execute][收到 Dept 刷新消息]");
        deptService.initLocalCache();
    }

}
