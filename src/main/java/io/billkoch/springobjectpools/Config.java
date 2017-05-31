package io.billkoch.springobjectpools;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.target.CommonsPool2TargetSource;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDateTime;

@Configuration
class Config {

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    MyObject myObject() {
        return new MyObject(LocalDateTime.now());
    }

    @Bean
    CommonsPool2TargetSource myObjectPool() {
        CommonsPool2TargetSource pool = new CommonsPool2TargetSource();
        pool.setMaxSize(10);
        pool.setTargetClass(MyObject.class);
        pool.setTargetBeanName("myObject");
        return pool;
    }

    @Bean
    ProxyFactoryBean proxyFactoryBean() {
        ProxyFactoryBean factoryBean = new ProxyFactoryBean();
        factoryBean.setTargetSource(myObjectPool());
        return factoryBean;
    }
}
