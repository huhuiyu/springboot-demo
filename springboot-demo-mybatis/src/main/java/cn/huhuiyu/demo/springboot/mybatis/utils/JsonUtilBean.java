package cn.huhuiyu.demo.springboot.mybatis.utils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class JsonUtilBean implements Serializable {
    private static final long serialVersionUID = 8379047733510223756L;

    private Map<String, Object> dataMap = new HashMap<String, Object>();

    public Map<String, Object> getDataMap() {
        return dataMap;
    }

    public String toJson() {
        return JSON.toJSONString(dataMap);
    }

    public static JsonUtilBean getMessageJson(String message) {
        JsonUtilBean bean = new JsonUtilBean();
        bean.getDataMap().put("message", message);
        return bean;
    }

    @SuppressWarnings("unchecked")
    public static Map<String, Object> json2Map(String json) {
        return JSON.parseObject(json, Map.class);
    }

    @SuppressWarnings("unchecked")
    public static List<Map<String, Object>> json2List(String json) {
        return JSON.parseObject(json, List.class);
    }

}
