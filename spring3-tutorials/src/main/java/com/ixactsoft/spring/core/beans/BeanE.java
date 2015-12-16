package com.ixactsoft.spring.core.beans;

/**
 * @author Ovidiu Lupas
 */
public class BeanE {

    private BeanC c;
    private BeanD d;

    public BeanE(BeanC c, BeanD d) {
        this.c = c;
        this.d = d;
        System.out.println("BeanE.BeanE ctor");
    }

    private void register() {
        System.out.println("BeanE.register");
        c.setD(d);
    }
}
