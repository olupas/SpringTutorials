package com.ixactsoft.spring.core.future;

/**
 * Created with IntelliJ IDEA.
 * User: Ovidiu Lupas
 * Date: 04.11.2015
 * Time: 21:39
 * To change this template use File | Settings | File Templates.
 */
public class TestBridgeMethods {
    public static class A<T> {
        public T getT(T args) {
            return args;
        }
    }

    public static class B extends A<String> {
        public String getT(String args) {
            return args;
        }
    }

    public static void main(String[] args) {
        A obj = new B();
        obj.getT(new Object());
    }
}
