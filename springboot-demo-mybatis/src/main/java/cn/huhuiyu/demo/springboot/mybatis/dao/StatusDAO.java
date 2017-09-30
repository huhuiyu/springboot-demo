package cn.huhuiyu.demo.springboot.mybatis.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StatusDAO {
    public List<Map<String, Object>> queryAll(Map<String, Object> params) throws Exception;
}
