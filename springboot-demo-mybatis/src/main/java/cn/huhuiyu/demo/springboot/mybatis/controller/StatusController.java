package cn.huhuiyu.demo.springboot.mybatis.controller;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.huhuiyu.demo.springboot.mybatis.exception.MyException;
import cn.huhuiyu.demo.springboot.mybatis.service.StatusService;
import cn.huhuiyu.demo.springboot.mybatis.utils.JsonMessage;

/**
 * 
 * @author huhuiyu
 *
 */
@RestController
@RequestMapping("/http/status")
public class StatusController {

    private static final Logger logger = LogManager.getLogger(StatusController.class);

    @Autowired
    private StatusService statusService;

    @RequestMapping("/queryAll")
    @ResponseBody
    public JsonMessage queryAll(@RequestParam Map<String, Object> params) {
        try {
            return statusService.queryAll(params);
        } catch (MyException ex) {
            return JsonMessage.getFailMessage(ex.getMessage(), ex.getCode());

        } catch (Exception ex) {
            logger.error("程序异常；", ex);
            return JsonMessage.getFailMessage(ex.getMessage());
        }
    }

}
