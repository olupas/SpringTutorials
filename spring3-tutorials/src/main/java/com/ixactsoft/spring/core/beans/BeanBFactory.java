package com.ixactsoft.spring.core.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author Ovidiu Lupas
 */
public class BeanBFactory implements FactoryBean<BeanB>, ApplicationContextAware {

    private ApplicationContext ctx;
    @Override
    public BeanB getObject() throws Exception {
       // ctx.getBean("beanA");
        return new BeanB();
    }

    @Override
    public Class<?> getObjectType() {
        return BeanB.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }
}
