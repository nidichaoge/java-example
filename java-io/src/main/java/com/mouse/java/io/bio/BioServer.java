package com.mouse.java.io.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author mouse
 * @version 1.0
 * @date 2020-01-20
 * @description
 */
public class BioServer {

    public static void main(String[] args) {
        new BioServer().start();
    }

    private void start(){
        try {
            ServerSocket serverSocket = new ServerSocket(80);
            while (true){
                Socket accept = serverSocket.accept();
                accept.getInputStream();
                accept.getOutputStream();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
