package com.javashun.cloud.module.pay.controller.admin.order.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - 支付订单详细信息 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PayOrderDetailsRespVO extends PayOrderBaseVO {

    @Schema(description = "支付订单编号", required = true, example = "1024")
    private Long id;

    @Schema(description = "应用名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "javashun")
    private String appName;

    @Schema(description = "创建时间", required = true)
    private LocalDateTime createTime;

    @Schema(description = "更新时间", required = true)
    private LocalDateTime updateTime;

    /**
     * 支付订单扩展
     */
    private PayOrderExtension extension;

    @Data
    @Schema(description = "支付订单扩展")
    public static class PayOrderExtension {

        @Schema(description = "支付订单号", required = true, example = "1024")
        private String no;

        @Schema(description = "支付异步通知的内容")
        private String channelNotifyData;

    }

}
