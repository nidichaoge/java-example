package com.mouse.java.io.nio;

import java.io.IOException;
import java.nio.channels.Selector;

/**
 * @author mouse
 * @version 1.0
 * @date 2020-01-20
 * @description
 */
public class NioServer {

    public static void main(String[] args) {
        try {
            Selector open = Selector.open();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
