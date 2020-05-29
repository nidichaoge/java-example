package com.mouse.java.jvm.demo2;

/**
 * @author mouse
 * @version 1.0
 * @date 2020/5/12
 * @description
 */
public class Test2 {

    public static void main(String[] args) {
        String a = "hello2";
        final String b = "hello";
        String c = "hello";

        String d = b+"2";
        String e = c+"2";
        String f = "hello" + "2";
        System.out.println(a == d); //true
        System.out.println(a == e); //false

        System.out.println(a == f); //true
    }
}
