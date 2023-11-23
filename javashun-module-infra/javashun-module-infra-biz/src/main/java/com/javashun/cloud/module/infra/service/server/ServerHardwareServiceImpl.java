package com.javashun.cloud.module.infra.service.server;

import com.javashun.cloud.framework.common.exception.util.ServiceExceptionUtil;
import com.javashun.cloud.framework.common.pojo.PageResult;
import com.javashun.cloud.module.infra.controller.admin.server.vo.ServerHardwareCreateReqVO;
import com.javashun.cloud.module.infra.controller.admin.server.vo.ServerHardwarePageReqVO;
import com.javashun.cloud.module.infra.controller.admin.server.vo.ServerHardwareUpdateReqVO;
import com.javashun.cloud.module.infra.convert.server.ServerHardwareConvert;
import com.javashun.cloud.module.infra.dal.dataobject.server.ServerHardwareDO;
import com.javashun.cloud.module.infra.dal.mysql.server.ServerHardwareMapper;
import com.javashun.cloud.module.infra.enums.ErrorCodeConstants;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * 字典类型 Service 实现类
 */
@Service
@Validated
public class ServerHardwareServiceImpl implements ServerHardwareService {

    @Resource
    private ServerHardwareMapper serverHardwareMapper;

    @Override
    public Long createServerHardware(ServerHardwareCreateReqVO createReqVO) {
        // 插入
        ServerHardwareDO ServerHardware = ServerHardwareConvert.INSTANCE.convert(createReqVO);
        serverHardwareMapper.insert(ServerHardware);
        // 返回
        return ServerHardware.getId();
    }

    @Override
    @CacheEvict(value = "serverHardware", key = "#updateReqVO.id")
    public void updateServerHardware(ServerHardwareUpdateReqVO updateReqVO) {
        // 校验存在
        validateServerHardwareExists(updateReqVO.getId());
        // 更新
        ServerHardwareDO updateObj = ServerHardwareConvert.INSTANCE.convert(updateReqVO);
        serverHardwareMapper.updateById(updateObj);
    }

    @Override
    @CacheEvict(value = "test", key = "#id")
    public void deleteServerHardware(Long id) {
        // 校验存在
        validateServerHardwareExists(id);
        // 删除
        serverHardwareMapper.deleteById(id);
    }

    private void validateServerHardwareExists(Long id) {
        if (serverHardwareMapper.selectById(id) == null) {
            throw ServiceExceptionUtil.exception(ErrorCodeConstants.TEST_DEMO_NOT_EXISTS);
        }
    }

    @Override
    @Cacheable(cacheNames = "test", key = "#id")
    public ServerHardwareDO getServerHardware(Long id) {
        return serverHardwareMapper.selectById(id);
    }

    @Override
    public List<ServerHardwareDO> getServerHardwareList(Collection<Long> ids) {
        return serverHardwareMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<ServerHardwareDO> getServerHardwarePage(ServerHardwarePageReqVO pageReqVO) {
//        ServerHardwareMapper.selectList2();
        return serverHardwareMapper.selectPage(pageReqVO);
    }

}
