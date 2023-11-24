package com.javashun.cloud.module.pay.api.refund;

import com.javashun.cloud.module.pay.api.refund.dto.PayRefundCreateReqDTO;
import com.javashun.cloud.module.pay.api.refund.dto.PayRefundRespDTO;
import com.javashun.cloud.module.pay.enums.ApiConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@FeignClient(name = ApiConstants.NAME) // TODO 芋艿：fallbackFactory =
@Tag(name = "RPC 服务 - 退款单")
public interface PayRefundApi {

    String PREFIX = ApiConstants.PREFIX + "/refund";

    @PostMapping(PREFIX + "/create")
    @Operation(summary = "创建退款单")
    Long createRefund(@Valid @RequestBody PayRefundCreateReqDTO reqDTO);

    @PostMapping(PREFIX + "/get")
    @Operation(summary = "获得退款单")
    @Parameter(name = "id", description = "退款单编号", example = "1", required = true)
    PayRefundRespDTO getRefund(Long id);

}
