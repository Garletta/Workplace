package com.example.homework7;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Homework7Activity extends AppCompatActivity {

    private EditText first;     //第一个数
    private EditText second;    //第二个数
    private Button compared;    //比较按钮
    private TextView showResult;//显示比较结果
    private MyService myService;//比较操作服务

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework7);

        first = findViewById(R.id.first);
        second = findViewById(R.id.second);
        compared = findViewById(R.id.compared);
        showResult = findViewById(R.id.showResult);

        final Intent intent = new Intent("homework7.service");
        intent.setPackage("com.example.homework7");
        bindService(intent,connection,BIND_AUTO_CREATE);

        compared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String a = first.getText().toString();
                String b = second.getText().toString();
                double fir = Double.parseDouble(a);
                double sec = Double.parseDouble(b);

                double result = myService.compare(fir, sec);
                String show;
                if(result != fir && result != sec) {
                     show = "两个数一样大!";
                } else {
                    show = "比较大的数为："+ result;
                }
                showResult.setText(show);
                Toast.makeText(Homework7Activity.this, show, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myService= ((MyService.LocalBinder)service).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            myService = null;
        }
    };
}
