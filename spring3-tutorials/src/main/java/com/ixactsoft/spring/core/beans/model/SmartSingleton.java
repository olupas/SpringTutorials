package com.ixactsoft.spring.core.beans.model;

import org.springframework.beans.factory.SmartInitializingSingleton;

/**
 * @author Ovidiu Lupas
 */
public class SmartSingleton implements SmartInitializingSingleton {

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public void afterSingletonsInstantiated() {
        setState("newstate");
    }
}
