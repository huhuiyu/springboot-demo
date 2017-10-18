package cn.huhuiyu.demo.springboot.mybatis.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;

/**
 * 
 * @author huhuiyu
 *
 */
public class Utils {
    private static final String PAGE_SIZE = "pageSize";
    private static final String PAGE_NUMBER = "pageNumber";

    public static Date getToday() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Map<String, Object> getPageInfo(Page<?> page) {
        Map<String, Object> pageinfo = new HashMap<String, Object>(16);
        pageinfo.put("total", page.getTotal());
        pageinfo.put(PAGE_NUMBER, page.getPageNum());
        pageinfo.put(PAGE_SIZE, page.getPageSize());
        pageinfo.put("pageCount", page.getPages());
        return pageinfo;
    }

    public static List<Integer> parsePageInfo(Map<String, Object> params) {
        List<Integer> pageinfo = new ArrayList<Integer>();
        if (params.containsKey(PAGE_NUMBER)) {
            pageinfo.add(Integer.parseInt(params.get(PAGE_NUMBER).toString()));
        } else {
            pageinfo.add(1);
        }
        if (params.containsKey(PAGE_SIZE)) {
            pageinfo.add(Integer.parseInt(params.get(PAGE_SIZE).toString()));
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
