package com.javashun.cloud.module.infra.service.server;

import com.javashun.cloud.framework.common.pojo.PageResult;
import com.javashun.cloud.module.infra.controller.admin.server.vo.ServerHardwareCreateReqVO;
import com.javashun.cloud.module.infra.controller.admin.server.vo.ServerHardwarePageReqVO;
import com.javashun.cloud.module.infra.controller.admin.server.vo.ServerHardwareUpdateReqVO;
import com.javashun.cloud.module.infra.dal.dataobject.server.ServerHardwareDO;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

/**
 * 硬件信息 Service 接口
 */
public interface ServerHardwareService {

    /**
     * 创建硬件信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createServerHardware(@Valid ServerHardwareCreateReqVO createReqVO);

    /**
     * 更新硬件信息
     *
     * @param updateReqVO 更新信息
     */
    void updateServerHardware(@Valid ServerHardwareUpdateReqVO updateReqVO);

    /**
     * 删除硬件信息
     *
     * @param id 编号
     */
    void deleteServerHardware(Long id);

    /**
     * 获得硬件信息
     *
     * @param id 编号
     * @return 硬件信息
     */
    ServerHardwareDO getServerHardware(Long id);

    /**
     * 获得硬件信息列表
     *
     * @param ids 编号
     * @return 硬件信息列表
     */
    List<ServerHardwareDO> getServerHardwareList(Collection<Long> ids);

    /**
     * 获得硬件信息分页
     *
     * @param pageReqVO 分页查询
     * @return 硬件信息分页
     */
    PageResult<ServerHardwareDO> getServerHardwarePage(ServerHardwarePageReqVO pageReqVO);

}
