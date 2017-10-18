package cn.huhuiyu.demo.springboot.mybatis.config;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.pagehelper.PageHelper;

/**
 * 
 * @author huhuiyu
 *
 */
@Configuration
public class MybatisConfig {
    private static Logger logger = LogManager.getLogger(MybatisConfig.class);

    @Bean
    public PageHelper pageHelper() {
        logger.debug("MybatisConfig.pageHelper()");
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "true");
        pageHelper.setProperties(p);
        return pageHelper;
    }
}
