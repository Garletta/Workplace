package com.example;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ThirdActivity extends AppCompatActivity {

    ListView listView;
    EditText editText;
    Button button;
    Button button2;
    List<String> list3;
    ArrayAdapter<String> adapter;
    int i=0;

    final static int CONTEXT_MENU_1=Menu.FIRST;
    final static int CONTEXT_MENU_2=Menu.FIRST+1;
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {     //快捷菜单
        super.onCreateContextMenu(menu, v, menuInfo);
        //实例化菜单代码
        menu.add(0,CONTEXT_MENU_1,0,"修改");
        menu.add(0,CONTEXT_MENU_2,0,"删除");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getTitle().equals("修改")){
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    i=position;
                }
            });
            if(TextUtils.isEmpty(editText.getText())){
                Toast.makeText(ThirdActivity.this, "专业名称为空!", Toast.LENGTH_SHORT).show();
            }else {
                list3.set(i, editText.getText().toString());
                adapter.notifyDataSetChanged();
            }
        }
        if (item.getTitle().equals("删除")){
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    i=position;
                }
            });
            list3.remove(i);
            adapter.notifyDataSetChanged();
        }
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        listView = (ListView) findViewById(R.id.listview);
        editText = (EditText) findViewById(R.id.editText5);
        button = (Button) findViewById(R.id.button5);
        button2 = (Button) findViewById(R.id.button4);    //添加

        list3  =new ArrayList<String>();

        Intent intent=getIntent();
        list3=(List<String>)intent.getSerializableExtra("profession");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list3);
        listView.setAdapter(adapter);

        registerForContextMenu(listView);     //绑定菜单

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(editText.getText())){
                    Toast.makeText(ThirdActivity.this, "专业名称为空不加入", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(ThirdActivity.this, "添加" + editText.getText() + "到listview", Toast.LENGTH_SHORT).show();
                    list3.add(editText.getText().toString());
                    adapter.notifyDataSetChanged();  //动态刷新
                }
            }
        });

        final Intent intent2 = new Intent("shiyan2.broad");
        intent2.setPackage("com.example");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent result = new Intent();
                result.putExtra("name",(Serializable)list3);
                setResult(RESULT_OK,result);
                intent2.putExtra("name","专业list更改为："+"\n" + (Serializable)list3);
                sendBroadcast(intent2);
                finish();


            }
        });
    }
}
