package cn.huhuiyu.demo.springboot.mybatis.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author huhuiyu
 *
 */
@Mapper
public interface StatusDAO {
    /**
     * 查询全部Status信息
     * 
     * @param params
     *            查询参数
     * @return 查询结果集
     * @throws Exception
     *             查询发生异常
     */
     List<Map<String, Object>> queryAll(Map<String, Object> params) throws Exception;
}
