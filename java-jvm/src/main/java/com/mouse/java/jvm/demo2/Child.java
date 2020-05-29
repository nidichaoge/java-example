package com.mouse.java.jvm.demo2;

/**
 * @author mouse
 * @version 1.0
 * @date 2020/5/12
 * @description
 */
public class Child extends Parent {

    static {
        System.out.println("static child {}");
    }

    {
        System.out.println("child {}");
    }

    public Child(){
        System.out.println("child");
    }

    @Override
    public void say(){
        System.out.println("child say");
    }

}
