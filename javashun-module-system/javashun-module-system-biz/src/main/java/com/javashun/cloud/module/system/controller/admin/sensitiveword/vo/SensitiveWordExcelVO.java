package com.javashun.cloud.module.system.controller.admin.sensitiveword.vo;

import com.javashun.cloud.framework.excel.core.annotations.DictFormat;
import com.javashun.cloud.framework.excel.core.convert.DictConvert;
import com.javashun.cloud.framework.excel.core.convert.JsonConvert;
import com.javashun.cloud.module.system.enums.DictTypeConstants;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 敏感词 Excel VO
 */
@Data
public class SensitiveWordExcelVO {

    @ExcelProperty("编号")
    private Long id;

    @ExcelProperty("敏感词")
    private String name;

    @ExcelProperty(value = "标签", converter = JsonConvert.class)
    private List<String> tags;

    @ExcelProperty(value = "状态", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.COMMON_STATUS)
    private Integer status;

    @ExcelProperty("描述")
    private String description;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
