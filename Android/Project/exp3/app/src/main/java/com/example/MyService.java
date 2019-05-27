package com.example;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {

    double bmi,height1,weight1;
    String bmistring;
    BmiBinder binder = new BmiBinder();

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.

        String name = intent.getStringExtra("name");
        String height = intent.getStringExtra("height");
        String weight = intent.getStringExtra("weight");
        if(height.isEmpty()||weight.isEmpty()){
            Toast.makeText(this,"身高或体重为空！！！",Toast.LENGTH_LONG).show();
        }
        if(!height.isEmpty()&&!weight.isEmpty()) {
            height1 = Double.parseDouble(height);
            weight1 = Double.parseDouble(weight);
            bmi = weight1/((height1/100)*(height1/100));
            if(bmi<18.5) {
                Toast.makeText(this, name + "体型偏瘦", Toast.LENGTH_LONG).show();
                bmistring = "体型偏瘦";
            }
            else if(bmi>=18.5&&bmi<24) {
                Toast.makeText(this, name + "体重正常", Toast.LENGTH_LONG).show();
                bmistring = "体重正常";
            }
            else if(bmi>=24&&bmi<28) {
                Toast.makeText(this, name + "体型偏胖", Toast.LENGTH_LONG).show();
                bmistring = "体型偏胖";
            }
            else if(bmi>=28) {
                Toast.makeText(this, name + "体型肥胖", Toast.LENGTH_LONG).show();
                bmistring = "体型肥胖";
            }
        }
        return binder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //Toast.makeText(this,"onCreate",Toast.LENGTH_LONG).show();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    class BmiBinder extends Binder {

        String getbmi(){
            return bmistring;
        }
    }

}
