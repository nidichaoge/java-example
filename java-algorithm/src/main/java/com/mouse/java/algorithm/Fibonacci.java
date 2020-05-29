package com.mouse.java.algorithm;

/**
 * @author mouse
 * @version 1.0
 * @date 2020/5/11
 * @description
 */
public class Fibonacci {

    public static void main(String[] args) {
        int function = new Fibonacci().function(4);
        System.out.println(function);
    }

    private int function(int n){
        if (n <= 1){
            return 1;
        }
        return function(n-1)+function(n-2);
    }
}
