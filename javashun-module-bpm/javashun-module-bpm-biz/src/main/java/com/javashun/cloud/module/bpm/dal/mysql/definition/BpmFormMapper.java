package com.javashun.cloud.module.bpm.dal.mysql.definition;


import com.javashun.cloud.module.bpm.controller.admin.definition.vo.form.BpmFormPageReqVO;
import com.javashun.cloud.module.bpm.dal.dataobject.definition.BpmFormDO;
import com.javashun.cloud.framework.common.pojo.PageResult;
import com.javashun.cloud.framework.mybatis.core.mapper.BaseMapperX;
import com.javashun.cloud.framework.mybatis.core.query.QueryWrapperX;
import org.apache.ibatis.annotations.Mapper;

/**
 * 动态表单 Mapper
 */
@Mapper
public interface BpmFormMapper extends BaseMapperX<BpmFormDO> {

    default PageResult<BpmFormDO> selectPage(BpmFormPageReqVO reqVO) {
        return selectPage(reqVO, new QueryWrapperX<BpmFormDO>()
                .likeIfPresent("name", reqVO.getName())
                .orderByDesc("id"));
    }

}
