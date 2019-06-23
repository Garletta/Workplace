package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button submit = findViewById(R.id.button);
        final EditText account = findViewById(R.id.editText1);
        final EditText password = findViewById(R.id.editText2);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Account = account.getText().toString();
                String Password = password.getText().toString();

                Intent intent=new Intent(Main2Activity.this,MainActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("Account",Account);
                bundle.putString("Password",Password);

                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }
}
