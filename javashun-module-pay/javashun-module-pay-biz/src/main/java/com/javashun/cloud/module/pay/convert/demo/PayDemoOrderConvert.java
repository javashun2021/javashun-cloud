package com.javashun.cloud.module.pay.convert.demo;

import com.javashun.cloud.module.pay.controller.admin.demo.vo.PayDemoOrderCreateReqVO;
import com.javashun.cloud.module.pay.controller.admin.demo.vo.PayDemoOrderRespVO;
import com.javashun.cloud.module.pay.dal.dataobject.demo.PayDemoOrderDO;
import com.javashun.cloud.framework.common.pojo.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 示例订单 Convert
 *
 * @author javashun
 */
@Mapper
public interface PayDemoOrderConvert {

    PayDemoOrderConvert INSTANCE = Mappers.getMapper(PayDemoOrderConvert.class);

    PayDemoOrderDO convert(PayDemoOrderCreateReqVO bean);

    PayDemoOrderRespVO convert(PayDemoOrderDO bean);

    PageResult<PayDemoOrderRespVO> convertPage(PageResult<PayDemoOrderDO> page);

}
