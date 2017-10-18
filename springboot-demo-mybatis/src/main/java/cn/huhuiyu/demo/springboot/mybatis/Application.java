package cn.huhuiyu.demo.springboot.mybatis;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author huhuiyu
 *
 */
@SpringBootApplication
public class Application {
    private final static Logger logger = LogManager.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        logger.info("应用程序启动完毕。。。");
    }

}
