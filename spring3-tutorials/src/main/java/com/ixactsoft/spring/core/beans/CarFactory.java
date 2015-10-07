package com.ixactsoft.spring.core.beans;

import com.ixactsoft.spring.core.beans.model.Car;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created with IntelliJ IDEA.
 * User: Ovidiu Lupas
 * Date: 07.10.2015
 * Time: 21:33
 * To change this template use File | Settings | File Templates.
 */
public class CarFactory implements FactoryBean<Car>, InitializingBean {
    private int year;
    private String name;

    private Car car;

    public void setYear(int year) {
        this.year = year;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Car getObject() throws Exception {
        Car car = new Car(year, name);
        return car;
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("CarFactory.afterPropertiesSet");
    }
}
