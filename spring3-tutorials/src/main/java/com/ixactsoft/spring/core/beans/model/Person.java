package com.ixactsoft.spring.core.beans.model;

import org.springframework.beans.factory.BeanNameAware;

/**
 * Created with IntelliJ IDEA.
 * User: Ovidiu Lupas
 * Date: 07.10.2015
 * Time: 21:28
 * To change this template use File | Settings | File Templates.
 */
public class Person implements BeanNameAware {

    private Car car;

    public void setCar(Car car) {
        this.car = car;
    }

    public void setBeanName(String name) {
        System.out.println("Person.setBeanName" + name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "car=" + car +
                '}';
    }
}
