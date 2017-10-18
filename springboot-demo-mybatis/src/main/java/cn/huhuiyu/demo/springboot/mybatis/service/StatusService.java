package cn.huhuiyu.demo.springboot.mybatis.service;

import java.util.Map;

import cn.huhuiyu.demo.springboot.mybatis.utils.JsonMessage;

/**
 * 
 * @author huhuiyu
 *
 */
public interface StatusService {
    /**
     * 查询全部Status信息
     * 
     * @param params
     *            查询参数
     * @return 查询结果集
     * @throws Exception
     *             查询发生异常
     */
    JsonMessage queryAll(Map<String, Object> params) throws Exception;
}
