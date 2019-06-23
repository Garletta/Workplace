package com.example.homework7;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {

    private final IBinder compareBinder = new LocalBinder();

    public class LocalBinder extends Binder{
        MyService getService(){
            return MyService.this;
        }
    }

    public double compare(double a,double b) {

        if(a > b) {
            return a;
        } else if(a < b){
            return b;
        } else {
            return a + b;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(this, "绑定成功！！！", Toast.LENGTH_SHORT).show();
        return compareBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
