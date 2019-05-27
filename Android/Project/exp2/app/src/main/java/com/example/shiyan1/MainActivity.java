package com.example.shiyan1;

import android.app.Activity;
import android.app.Notification;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {//spinner
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = findViewById(R.id.spinner);
        ArrayList<String> profession = new ArrayList<>();
        profession.add("计算机");
        profession.add("软件工程");
        profession.add("物联网");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,profession);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(0);

        ListView listView = findViewById(R.id.ListView01);
        final ArrayList<String> list2 = new ArrayList<>();
        list2.add("林锦雄");
        list2.add("湖畔");
        list2.add("卖奶茶");
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list2);
        listView.setAdapter(adapter2);
        registerForContextMenu(listView);

        final Button exit = findViewById(R.id.button2);//关闭app
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exit();//关闭app
            }
        });
        MainActivity.activityList.add(this);

        final Button add = findViewById(R.id.button3);//添加
        final ListView listView2 = findViewById(R.id.ListView01);
        final EditText name = findViewById(R.id.editText4);
        name.setFocusable(true);
        name.setFocusableInTouchMode(true);
        final ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list2);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listView2.setAdapter(adapter3);
                if (TextUtils.isEmpty(name.getText())){
                    Toast.makeText(MainActivity.this,"姓名为空不加入",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"添加"+name.getText()+"到listview",Toast.LENGTH_SHORT).show();
                    list2.add(name.getText().toString());
                    adapter3.notifyDataSetChanged();//动态刷新
                }
            }
        });

        final EditText weight = findViewById(R.id.editText3);//体重的限制
        weight.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                if(keyCode >= 7 && keyCode <= 16 || keyCode == 56 || keyCode == 67){
                    return true;
                }else{
                    Toast.makeText(getApplicationContext(),"输入有误，请输入数字和字符“.” ",Toast.LENGTH_SHORT).show();
                    return false;
                }
            }
        });

        final EditText height = findViewById(R.id.editText2);//身高的限制
        height.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                if(keyCode >= 7 && keyCode <= 16 || keyCode == 56 || keyCode == 67){
                    return true;
                }else{
                    Toast.makeText(getApplicationContext(),"输入有误，请输入数字和字符“.” ",Toast.LENGTH_SHORT).show();
                    return false;
                }
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {//选项菜单
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    final static int CONTEXT_MENU_1 = Menu.FIRST;//快捷菜单
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        menu.add(0,CONTEXT_MENU_1,0,"查看");
    }

    public static List<Activity> activityList = new LinkedList();
    public void exit() {//关闭
        for(Activity act : activityList) {
            act.finish();
        }
        System.exit(0);
    }
}
