package com.fosung.pro.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * service接口实现类配置
 * @Author : liupeng
 * @Date : 2019-06-10
 * @Modified By liupeng
 */
@Slf4j
@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
@ComponentScan(basePackages = "com.fosung.pro.service")//com.fosung.pro.service
public class ProServiceAutoConfiguration {

    public ProServiceAutoConfiguration() {
        log.info("初始化服务实现类");
    }

}
