package com.javashun.cloud.module.infra.convert.server;

import com.javashun.cloud.framework.common.pojo.PageResult;
import com.javashun.cloud.module.infra.controller.admin.server.vo.ServerHardwareCreateReqVO;
import com.javashun.cloud.module.infra.controller.admin.server.vo.ServerHardwareRespVO;
import com.javashun.cloud.module.infra.controller.admin.server.vo.ServerHardwareUpdateReqVO;
import com.javashun.cloud.module.infra.dal.dataobject.server.ServerHardwareDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ServerHardwareConvert {

    ServerHardwareConvert INSTANCE = Mappers.getMapper(ServerHardwareConvert.class);

    ServerHardwareDO convert(ServerHardwareCreateReqVO bean);

    ServerHardwareDO convert(ServerHardwareUpdateReqVO bean);

    ServerHardwareRespVO convert(ServerHardwareDO bean);

    List<ServerHardwareRespVO> convertList(List<ServerHardwareDO> list);

    PageResult<ServerHardwareRespVO> convertPage(PageResult<ServerHardwareDO> page);
    
}
