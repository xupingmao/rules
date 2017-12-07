package com.xpm.rules;

/**
 * 基本规则
 * Created by xupingmao on 2017/3/28.
 */
public interface Rule<T> {

    /**
     * 必须定义名称，方便记录日志，排除问题
     * @return
     */
    String getName();

    /**
     * 规则的条件，也就是前件
     * 抽离出来可以让控制机构生成路由
     * @param globalContext
     * @return
     */
    boolean match(T globalContext);

    /**
     * 规则的操作，后件
     * @param globalContext 全局上下文
     * @return
     */
    void execute(RuleEngine ruleEngine, T globalContext);

}