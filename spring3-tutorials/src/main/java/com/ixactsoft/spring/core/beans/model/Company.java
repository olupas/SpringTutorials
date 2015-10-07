package com.ixactsoft.spring.core.beans.model;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: Ovidiu Lupas
 * Date: 07.10.2015
 * Time: 22:18
 * To change this template use File | Settings | File Templates.
 */
public class Company implements InitializingBean, DisposableBean {

    @Autowired
    private Person president;

   @Autowired(required = false)
   private Car presidentCar;

    @Override
    public String toString() {
        return "Company{" +
                "president=" + president +
                '}';
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Company.afterPropertiesSet" + this);
        System.out.println(this);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Company.destroy");
    }
}
