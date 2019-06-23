package com.example;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class secondActivity extends AppCompatActivity {

    String bmi;
    List<String> bmilist = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Toast.makeText(this,getIntent().getStringExtra("name"),Toast.LENGTH_LONG).show();

        TextView textView = (TextView)findViewById(R.id.textView12);
        TextView textView2 = (TextView)findViewById(R.id.textView14);
        TextView textView3 = (TextView)findViewById(R.id.textView16);
        TextView textView4 = (TextView)findViewById(R.id.textView18);
        TextView textView5 = (TextView)findViewById(R.id.textView20);
        TextView textView6 = (TextView)findViewById(R.id.textView22);
        TextView textView7 = (TextView)findViewById(R.id.textView28);

        Intent intent3=getIntent();
        Student student= (Student) intent3.getSerializableExtra("name");
        bmi = intent3.getStringExtra("bmi");
        //bmilist = (List<String>)intent3.getSerializableExtra("bmi");

        if (student != null){
            textView.setText(student.getName());
            textView2.setText(student.getHeight());
            textView3.setText(student.getWeight());
            textView4.setText(student.getSex());
            textView5.setText(student.getHobby());
            textView6.setText(student.getProfession());

        }
        textView7.setText(bmi);

        final Button button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent result = new Intent(null,Uri.parse("跳转回："));
                result.putExtra("name","第一个界面");
                setResult(RESULT_OK,result);
                finish();
            }
        });
    }
}
