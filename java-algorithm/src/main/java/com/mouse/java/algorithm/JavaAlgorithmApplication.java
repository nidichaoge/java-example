package com.mouse.java.algorithm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaAlgorithmApplication {

    public static void main(String[] args) {

        new Thread(()-> {
            try {
                Thread.sleep(50000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
//        SpringApplication.run(JavaAlgorithmApplication.class, args);
        System.out.println("hello");
    }

}
