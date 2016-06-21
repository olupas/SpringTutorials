package com.ixactsoft.spring.core.beans;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;

/**
 * @author Ovidiu Lupas
 */
public class BeanC implements InitializingBean {
  private BeanD d;

    public BeanC(BeanD d) {
        this.d = d;
        System.out.println("BeanC.BeanC ctor");
    }

    public void setD(BeanD d) {
        this.d = d;
        System.out.println("BeanC.setD");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("BeanC.afterPropertiesSet");
    }
}
