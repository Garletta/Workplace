package com.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class StorageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);

        Button choose = (Button) findViewById(R.id.button8);
        /*choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radioButton3.isChecked()) Saveway = "sql";
                else if(radioButton4.isChecked()) Saveway = "inside";
                else if(radioButton4.isChecked()) Saveway = "outside";
                Uri data = Uri.parse(Saveway);
                Intent result = new Intent(null,data);
                setResult(RESULT_OK,result);
                finish();
            }
        });*/

    }
}
