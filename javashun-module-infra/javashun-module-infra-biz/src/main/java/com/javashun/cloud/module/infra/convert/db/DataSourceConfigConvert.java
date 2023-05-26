package com.javashun.cloud.module.infra.convert.db;

import java.util.*;

import com.javashun.cloud.module.infra.controller.admin.db.vo.DataSourceConfigCreateReqVO;
import com.javashun.cloud.module.infra.controller.admin.db.vo.DataSourceConfigRespVO;
import com.javashun.cloud.module.infra.controller.admin.db.vo.DataSourceConfigUpdateReqVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.javashun.cloud.module.infra.controller.admin.db.vo.*;
import com.javashun.cloud.module.infra.dal.dataobject.db.DataSourceConfigDO;

/**
 * 数据源配置 Convert
 */
@Mapper
public interface DataSourceConfigConvert {

    DataSourceConfigConvert INSTANCE = Mappers.getMapper(DataSourceConfigConvert.class);

    DataSourceConfigDO convert(DataSourceConfigCreateReqVO bean);

    DataSourceConfigDO convert(DataSourceConfigUpdateReqVO bean);

    DataSourceConfigRespVO convert(DataSourceConfigDO bean);

    List<DataSourceConfigRespVO> convertList(List<DataSourceConfigDO> list);

}
