package cn.huhuiyu.demo.springboot.mybatis.service;

import java.util.Map;

import cn.huhuiyu.demo.springboot.mybatis.utils.JsonMessage;

public interface StatusService {
    JsonMessage queryAll(Map<String, Object> params) throws Exception;
}
