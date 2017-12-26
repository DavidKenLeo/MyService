package com.dkl.auser.myservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("MainActivity.onCreate");
    }
    public void b1(){
        System.out.print("start");
        Intent it = new Intent(this,MyService.class);
        MyService.isStop = false;
        startService(it);
    }
    public void b2(){
        System.out.print("stop");
        Intent it = new Intent(this,MyService.class);
        MyService.isStop = true;

        stopService(it);
    }

}
