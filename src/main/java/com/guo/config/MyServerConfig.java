package com.guo.config;

import com.guo.filter.MyFilter;
import com.guo.listener.MyListener;
import com.guo.servlet.MyServlet;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author guo
 * @create 2019-05-21 14:25
 */
@Configuration
public class MyServerConfig {
    //注册三大组件
    @Bean
    public ServletRegistrationBean myServlet(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new MyServlet(),"/myServlet");
        registrationBean.setLoadOnStartup(1);
        return registrationBean;
    }
    //过滤器
    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new MyFilter());
        registrationBean.setUrlPatterns(Arrays.asList("/hello","/myServlet"));
        return registrationBean;
    }
    //监听器
    @Bean
    public ServletListenerRegistrationBean myListener(){
        ServletListenerRegistrationBean<MyListener> registrationBean = new ServletListenerRegistrationBean<>(new MyListener());
        return registrationBean;
    }
    //配置嵌入式的Servlet容器（tomcat等）
//    @Bean
//    public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer(){
//        return new EmbeddedServletContainerCustomizer() {
//            //定制嵌入式的Servlet容器相关的规则
//            @Override
//            public void customize(ConfigurableEmbeddedServletContainer container) {
//                container.setPort(8083);
//            }
//        };
//    }
}
