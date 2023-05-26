package com.javashun.cloud.module.report.dal.mysql.goview;

import com.javashun.cloud.framework.common.pojo.PageParam;
import com.javashun.cloud.framework.common.pojo.PageResult;
import com.javashun.cloud.framework.mybatis.core.mapper.BaseMapperX;
import com.javashun.cloud.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.javashun.cloud.module.report.dal.dataobject.goview.GoViewProjectDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoViewProjectMapper extends BaseMapperX<GoViewProjectDO> {

    default PageResult<GoViewProjectDO> selectPage(PageParam reqVO, Long userId) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GoViewProjectDO>()
                .eq(GoViewProjectDO::getCreator, userId)
                .orderByDesc(GoViewProjectDO::getId));
    }

}
