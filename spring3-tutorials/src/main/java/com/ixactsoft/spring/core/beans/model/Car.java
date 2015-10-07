package com.ixactsoft.spring.core.beans.model;

/**
 * Created with IntelliJ IDEA.
 * User: Ovidiu Lupas
 * Date: 07.10.2015
 * Time: 21:28
 * To change this template use File | Settings | File Templates.
 */
public class Car {
    private int year;
    private String name;
    private CarType type;
    private double price;

    public Car(int year, String name) {
        this.year = year;
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(CarType type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "year=" + year +
                ", name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
