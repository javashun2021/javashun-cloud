package com.javashun.cloud.framework.datapermisssion.core.rule;

import com.javashun.cloud.framework.datapermisssion.core.rule.DataPermissionRule;

import java.util.List;

/**
 * {@link DataPermissionRule} 工厂接口
 * 作为 {@link DataPermissionRule} 的容器，提供管理能力
 */
public interface DataPermissionRuleFactory {

    /**
     * 获得所有数据权限规则数组
     *
     * @return 数据权限规则数组
     */
    List<DataPermissionRule> getDataPermissionRules();

    /**
     * 获得指定 Mapper 的数据权限规则数组
     *
     * @param mappedStatementId 指定 Mapper 的编号
     * @return 数据权限规则数组
     */
    List<DataPermissionRule> getDataPermissionRule(String mappedStatementId);

}