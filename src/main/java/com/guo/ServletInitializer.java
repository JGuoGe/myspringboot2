package com.guo;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 有这个类说明是war项目，使用外置servlet容器启动项目，
 * 不能使用MyspringbootApplication的main方法的形式启动，需要给idea配置外置的tomcat
 * @author guo
 * @create 2019-05-21 13:52
 */
public class ServletInitializer  extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MyspringbootApplication.class);
    }
}
//public class ServletInitializer{}