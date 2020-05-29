package com.mouse.java.io.bio;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * @author mouse
 * @version 1.0
 * @date 2020-01-20
 * @description
 */
public class BioClient {

    /**
     * 手动创建一个线程池
     */
    private static final ThreadPoolExecutor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(2,5,30, TimeUnit.SECONDS,
            new LinkedBlockingDeque<>(1000), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {
        new BioClient().start();
    }

    private void start(){
       THREAD_POOL_EXECUTOR.execute(() -> {
           try {
               Socket socket = new Socket("127.0.0.1",80);
               socket.getOutputStream();
               socket.getInputStream();
           } catch (IOException e) {
               e.printStackTrace();
           }
       });
    }
}
