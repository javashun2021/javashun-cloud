package com.javashun.cloud.module.pay.api.order;

import com.javashun.cloud.module.pay.api.order.dto.PayOrderCreateReqDTO;
import com.javashun.cloud.module.pay.api.order.dto.PayOrderRespDTO;
import com.javashun.cloud.module.pay.convert.order.PayOrderConvert;
import com.javashun.cloud.module.pay.dal.dataobject.order.PayOrderDO;
import com.javashun.cloud.module.pay.service.order.PayOrderService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Service
@RestController // 提供 RESTful API 接口，给 Feign 调用
@Validated
public class PayOrderApiImpl implements PayOrderApi {

    @Resource
    private PayOrderService payOrderService;

    @Override
    public Long createOrder(PayOrderCreateReqDTO reqDTO) {
        return payOrderService.createOrder(reqDTO);
    }

    @Override
    public PayOrderRespDTO getOrder(Long id) {
        PayOrderDO order = payOrderService.getOrder(id);
        return PayOrderConvert.INSTANCE.convert2(order);
    }

}
