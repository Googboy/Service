package com.example.learnservice;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

public class MainActivity extends Activity implements View.OnClickListener, ServiceConnection {
    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i = new Intent(MainActivity.this,MyService.class);

        findViewById(R.id.btnStartService).setOnClickListener(this);
        findViewById(R.id.btnStopService).setOnClickListener(this);
        findViewById(R.id.btnBindService).setOnClickListener(this);
        findViewById(R.id.btnUnBindService).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnStartService:
                startService(i);
                break;
            case R.id.btnStopService:
                stopService(i);
                break;
            case R.id.btnBindService:
                bindService(i,this, Context.BIND_AUTO_CREATE);
                break;
            case R.id.btnUnBindService:
                unbindService(this);
                break;
        }
    }
    //服务绑定成功后执行下面这个方法
    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        System.out.println("服务连接成功");
    }
   //服务崩溃或者被杀掉时执行这个方法
    @Override
    public void onServiceDisconnected(ComponentName name) {
    }
}
