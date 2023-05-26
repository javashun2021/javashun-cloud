package com.javashun.cloud.module.system.mq.producer.notify;

import com.javashun.cloud.framework.mq.core.bus.AbstractBusProducer;
import com.javashun.cloud.module.system.mq.message.notify.NotifyTemplateRefreshMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Notify 站内信相关消息的 Producer
 */
@Slf4j
@Component
public class NotifyProducer extends AbstractBusProducer {

    /**
     * 发送 {@link NotifyTemplateRefreshMessage} 消息
     */
    public void sendNotifyTemplateRefreshMessage() {
        publishEvent(new NotifyTemplateRefreshMessage(this, getBusId(), selfDestinationService()));
    }


}
