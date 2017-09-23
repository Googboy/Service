package com.example.learnservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service {
    private boolean running = false;
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {

        return new Binder();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(){
            @Override
            public void run() {
                running = true;
                super.run();
                while (running) {
                    System.out.println("服务正在运行");
                    try {
                        sleep(1000);//设置每隔一秒输出一句话
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();



        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("Service Oncreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        running = false;
        System.out.println("Service Ondestroy");
    }
}
