package com.javashun.cloud.module.infra.controller.admin.file.vo.file;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description =   "管理后台 - 文件 Response VO,不返回 content 字段，太大" )
@Data
public class FileRespVO {

    @Schema(description = "文件编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "文件路径", requiredMode = Schema.RequiredMode.REQUIRED, example = "javashun.jpg")
    private String path;

    @Schema(description = "文件 URL", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.javashun.com/javashun.jpg")
    private String url;

    @Schema(description = "文件类型", example = "jpg")
    private String type;

    @Schema(description = "文件大小", example = "2048", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer size;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}