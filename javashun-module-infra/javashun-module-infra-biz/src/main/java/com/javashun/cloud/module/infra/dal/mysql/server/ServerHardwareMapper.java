package com.javashun.cloud.module.infra.dal.mysql.server;

import com.javashun.cloud.framework.common.pojo.PageResult;
import com.javashun.cloud.framework.mybatis.core.mapper.BaseMapperX;
import com.javashun.cloud.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.javashun.cloud.module.infra.controller.admin.server.vo.ServerHardwarePageReqVO;
import com.javashun.cloud.module.infra.dal.dataobject.server.ServerHardwareDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 硬件服务器 Mapper
 */
@Mapper
public interface ServerHardwareMapper extends BaseMapperX<ServerHardwareDO> {

    default PageResult<ServerHardwareDO> selectPage(ServerHardwarePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ServerHardwareDO>()
                .likeIfPresent(ServerHardwareDO::getIp, reqVO.getIp())
                .eqIfPresent(ServerHardwareDO::getStatus, reqVO.getStatus())
                .eqIfPresent(ServerHardwareDO::getType, reqVO.getType())
                .eqIfPresent(ServerHardwareDO::getRemark, reqVO.getRemark())
                .betweenIfPresent(ServerHardwareDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ServerHardwareDO::getId));
    }

}
