package com.mouse.java.jvm.demo2;

/**
 * @author mouse
 * @version 1.0
 * @date 2020/5/12
 * @description
 */
public class Parent {

    static {
        System.out.println("static parent {}");
    }

    {
        System.out.println("parent {}");
    }

    public Parent(){
        System.out.println("parent");
    }

    public void say(){
        System.out.println("parent say");
    }

}
