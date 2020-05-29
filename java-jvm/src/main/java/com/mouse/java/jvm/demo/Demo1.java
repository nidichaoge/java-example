package com.mouse.java.jvm.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mouse
 * @version 1.0
 * @date 2020/5/11
 * @description
 */
public class Demo1 {

    private static final int SIZE = 1024;

    public static void main(String[] args) {
        List<byte[]> bytes = new ArrayList<>();
        while (true){
            bytes.add(new byte[SIZE  * SIZE * 8]);
            try {
                Thread.sleep(1000);
            }catch (Exception e){

            }
        }
    }

}
