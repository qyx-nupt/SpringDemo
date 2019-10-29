package com.qyx.springbootdemologback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@SpringBootApplication
public class SpringBootDemoLogbackApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootDemoLogbackApplication.class, args);
        int len = context.getBeanDefinitionCount();
        log.trace("log trace - length: " + len);
        log.info("log info - length: " + len);
        log.warn("log warn - length: " + len);
        log.error("log error - length: " + len);
        try {
            int i = 0 ;
            int j =8/i;
        } catch (Exception e) {
            log.error( "catch error:" + e.toString());
        }
    }

}
