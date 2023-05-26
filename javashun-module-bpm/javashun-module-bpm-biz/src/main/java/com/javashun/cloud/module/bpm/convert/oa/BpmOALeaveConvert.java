package com.javashun.cloud.module.bpm.convert.oa;

import com.javashun.cloud.framework.common.pojo.PageResult;
import com.javashun.cloud.module.bpm.controller.admin.oa.vo.BpmOALeaveCreateReqVO;
import com.javashun.cloud.module.bpm.controller.admin.oa.vo.BpmOALeaveRespVO;
import com.javashun.cloud.module.bpm.dal.dataobject.oa.BpmOALeaveDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 请假申请 Convert
 */
@Mapper
public interface BpmOALeaveConvert {

    BpmOALeaveConvert INSTANCE = Mappers.getMapper(BpmOALeaveConvert.class);

    BpmOALeaveDO convert(BpmOALeaveCreateReqVO bean);

    BpmOALeaveRespVO convert(BpmOALeaveDO bean);

    List<BpmOALeaveRespVO> convertList(List<BpmOALeaveDO> list);

    PageResult<BpmOALeaveRespVO> convertPage(PageResult<BpmOALeaveDO> page);

}
