package cn.huhuiyu.demo.springboot.mybatis.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;

public class Utils {
    public static Date getToday() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Map<String, Object> getPageInfo(Page<?> page) {
        Map<String, Object> pageinfo = new HashMap<String, Object>();
        pageinfo.put("total", page.getTotal());
        pageinfo.put("pageNumber", page.getPageNum());
        pageinfo.put("pageSize", page.getPageSize());
        pageinfo.put("pageCount", page.getPages());
        return pageinfo;
    }

    public static List<Integer> parsePageInfo(Map<String, Object> params) {
        List<Integer> pageinfo = new ArrayList<Integer>();
        if (params.containsKey("pageNumber")) {
            pageinfo.add(Integer.parseInt(params.get("pageNumber").toString()));
        } else {
            pageinfo.add(1);
        }
        if (params.containsKey("pageSize")) {
            pageinfo.add(Integer.parseInt(params.get("pageSize").toString()));
        } else {
            pageinfo.add(10);
        }
        return pageinfo;
    }

    public static void paramsLike(Map<String, Object> params, String key) {
        if (params.containsKey(key)) {
            params.put(key, String.format("%%%s%%", params.get(key)));
        }
    }
}
