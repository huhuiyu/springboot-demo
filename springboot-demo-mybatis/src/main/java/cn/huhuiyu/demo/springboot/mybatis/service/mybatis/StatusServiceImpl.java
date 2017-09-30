package cn.huhuiyu.demo.springboot.mybatis.service.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.huhuiyu.demo.springboot.mybatis.dao.StatusDAO;
import cn.huhuiyu.demo.springboot.mybatis.service.StatusService;
import cn.huhuiyu.demo.springboot.mybatis.utils.JsonMessage;
import cn.huhuiyu.demo.springboot.mybatis.utils.Utils;

@Component
@Transactional(rollbackFor = Exception.class)
public class StatusServiceImpl implements StatusService {
    @Autowired
    private StatusDAO statusDAO;

    public JsonMessage queryAll(Map<String, Object> params) throws Exception {
        Map<String, Object> dataMap = new HashMap<String, Object>();
        List<Integer> list = Utils.parsePageInfo(params);
        PageHelper.startPage(list.get(0), list.get(1));
        Page<Map<String, Object>> page = (Page<Map<String, Object>>) statusDAO.queryAll(params);
        dataMap.put("status", page);
        dataMap.put("page", Utils.getPageInfo(page));
        return JsonMessage.getSuccessMessage("", dataMap);
    }

}
