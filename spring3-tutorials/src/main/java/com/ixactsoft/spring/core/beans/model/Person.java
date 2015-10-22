package com.ixactsoft.spring.core.beans.model;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created with IntelliJ IDEA.
 * User: Ovidiu Lupas
 * Date: 07.10.2015
 * Time: 21:28
 * To change this template use File | Settings | File Templates.
 */
public class Person implements BeanNameAware, InitializingBean {

    private Car car;
    private String name;

    public void setCar(Car car) {
        this.car = car;
    }

    public void setBeanName(String name) {
        System.out.println("Person.setBeanName" + name);
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "car=" + car +
                '}';
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println(this);
    }
}
