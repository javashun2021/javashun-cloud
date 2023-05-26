package com.javashun.cloud.framework.datapermission.core.utils;

import com.javashun.cloud.framework.datapermisssion.core.aop.DataPermissionContextHolder;
import com.javashun.cloud.framework.datapermisssion.core.util.DataPermissionUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DataPermissionUtilsTest {

    @Test
    public void testExecuteIgnore() {
        DataPermissionUtils.executeIgnore(() -> assertFalse(DataPermissionContextHolder.get().enable()));
    }

}
