package com.javashun.cloud.module.infra.dal.dataobject.server;

import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.javashun.cloud.framework.mybatis.core.dataobject.BaseDO;
import lombok.*;

@TableName("infra_server_hardware")
@KeySequence("infra_server_hardware_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServerHardwareDO extends BaseDO {
    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * ip
     */
    private String ip;

    /**
     * 类型
     */
    private Integer type;

    /**
     * detail
     */
    private String detail;

    /**
     * 登入名
     */
    private String username;

    /**
     * 登入密码
     */
    private String pwd;

    /**
     * 登入pem文件
     */
    private String pemUrl;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 备注
     */
    private String remark;
}
