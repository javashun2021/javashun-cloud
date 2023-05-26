package com.javashun.cloud.framework.common.util.object;

import com.javashun.cloud.framework.common.pojo.PageParam;

/**
 * {@link com.javashun.cloud.framework.common.pojo.PageParam} 工具类
 *
 * @author javashun
 */
public class PageUtils {

    public static int getStart(PageParam pageParam) {
        return (pageParam.getPageNo() - 1) * pageParam.getPageSize();
    }

}
