package cn.huhuiyu.demo.springboot.mybatis.utils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.annotation.JSONType;

/**
 * 
 * @author huhuiyu
 *
 */
@JSONType(typeName = "JsonMessage")
public class JsonMessage implements Serializable {
    private static final long serialVersionUID = 5414116991779501076L;
    /**
     * 是否成功
     */
    private boolean success = false;
    /**
     * 服务器消息
     */
    private String message = "服务器忙，请稍候重试";
    /**
     * 应答结果代码
     */
    private int code = 500;
    /**
     * 服务器数据
     */
    private Map<String, Object> dataMap = new HashMap<String, Object>();
    /**
     * 当前时间戳
     */
    private long now;

    public static JsonMessage getJsonMessage(boolean success, String message, int code, Map<String, Object> dataMap) {
        JsonMessage jsonMessage = new JsonMessage();
        jsonMessage.setSuccess(success);
        jsonMessage.setMessage(message);
        jsonMessage.setCode(code);
        if (dataMap != null && !dataMap.isEmpty()) {
            jsonMessage.putDatas(dataMap);
        }
        return jsonMessage;
    }

    public static JsonMessage getSuccessMessage(String message) {
        return JsonMessage.getJsonMessage(true, message, 200, null);
    }

    public static JsonMessage getSuccessMessage(String message, Map<String, Object> dataMap) {
        return JsonMessage.getJsonMessage(true, message, 200, dataMap);
    }

    public static JsonMessage getFailMessage(String message) {
        return JsonMessage.getJsonMessage(false, message, 500, null);
    }

    public static JsonMessage getFailMessage(String message, int code) {
        return JsonMessage.getJsonMessage(false, message, code, null);
    }

    public Map<String, Object> getDataMap() {
        return dataMap;
    }

    public void setDataMap(Map<String, Object> dataMap) {
        this.dataMap = dataMap;
    }

    public void putData(String key, Object data) {
        dataMap.put(key, data);
    }

    public void putDatas(Map<String, Object> datas) {
        dataMap.putAll(datas);
    }

    public void clearData() {
        dataMap.clear();
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public long getNow() {
        return now;
    }

    public JsonMessage() {
        now = Utils.getToday().getTime();
    }

    @Override
    public String toString() {
        return "JsonMessage [success=" + success + ", message=" + message + ", dataMap=" + dataMap + "]";
    }

}
