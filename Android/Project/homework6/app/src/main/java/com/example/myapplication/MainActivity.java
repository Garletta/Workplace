package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button submit = findViewById(R.id.but1);
        EditText account = findViewById(R.id.editText1);
        EditText password = findViewById(R.id.editText);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null)
        {
            String Account = bundle.getString("Account");
            String Password = bundle.getString("Password");
            account.setText(Account);
            password.setText(Password);
        }
    }

}
