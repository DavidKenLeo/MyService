package com.dkl.auser.myservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;

/**
 * Created by auser on 2017/11/21.
 */

public class MyService extends Service {


     static boolean isStop = true;
    private Thread t;
    private int count;

    public MyService(){
        System.out.println("MyService()");
    }

    @Override
    public void onCreate() {
        isStop = false;
        t = new Thread(){
            @Override
            public void run() {
                if(!isStop){
                    try {
                        Thread.sleep(1000);
                        System.out.print("Count"+count);
                    count++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    System.out.print("stop");

                }
            }
        };

        t.start();
        super.onCreate();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        isStop = true;
        t = null;
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
