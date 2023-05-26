package com.javashun.cloud.module.system.convert.mail;

import com.javashun.cloud.framework.common.pojo.PageResult;
import com.javashun.cloud.module.system.controller.admin.mail.vo.log.MailLogRespVO;
import com.javashun.cloud.module.system.dal.dataobject.mail.MailLogDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MailLogConvert {

    MailLogConvert INSTANCE = Mappers.getMapper(MailLogConvert.class);

    PageResult<MailLogRespVO> convertPage(PageResult<MailLogDO> pageResult);

    MailLogRespVO convert(MailLogDO bean);

}
