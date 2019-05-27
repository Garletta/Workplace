package com.example;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class shiyan1Activity extends AppCompatActivity {

    EditText editText;   //姓名
    EditText editText2;   //身高
    EditText editText3;   //体重

    Button button;    //关闭
    Button button2;   //添加
    Button button3;   //计算

    ListView listview;
    ListView listview2;

    Spinner spinner;

    RadioButton radioButton;
    RadioButton radioButton2;

    CheckBox checkBox;
    CheckBox checkBox2;
    CheckBox checkBox3;

    List<CheckBox> checkBoxList;

    ArrayList<Student> students = new ArrayList<>();
    List<String> list;
    List<String> list2;
    List<String> list3;

    int i=0;
    String name="";

    Student stu = new Student();
    public int num = 3;

    String bmi;
    private MyService.BmiBinder binder;
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //得到服务的返回binder
            binder = (MyService.BmiBinder)service;
            bmi = binder.getbmi();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {    //菜单
        //menu.add(0,1,1,"设置");
        //menu.addSubMenu(0,1,1,"设置").add(0,11,1,"专业设置");
        //利用菜单填充器将菜单资源文件映射成菜单
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    final Intent intent2 = new Intent("shiyan2",Uri.parse("http://shiyan2.third"));
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {      //子菜单事件
        super.onOptionsItemSelected(item);
        switch(item.getItemId()){
            case R.id.menu0:
                Toast.makeText(this,item.getTitle(),Toast.LENGTH_LONG).show();
                return true;
            case R.id.menu1:
                Toast.makeText(this, "专业设置", Toast.LENGTH_LONG).show();
                intent2.putExtra("profession", (Serializable)list); //显示在第二个界面
                //startActivity(intent2);
                startActivityForResult(intent2, 2);
                return true;
            default:
                return false;
        }
    }

    final static int CONTEXT_MENU_1=Menu.FIRST;
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {     //快捷菜单
        super.onCreateContextMenu(menu, v, menuInfo);
        //实例化菜单代码
        menu.add(0,CONTEXT_MENU_1,0,"查看");
    }

    //final Intent intent = new Intent(shiyan1Activity.this,secondActivity.class); //显式启动两个界面跳转，必须放在onCreate里面，否则出错
    //final Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baidu.com"));  //隐式启动跳转到网页
    final Intent intent = new Intent("shiyan2",Uri.parse("http://shiyan2.second"));  //隐式启动两个界面跳转
    @Override
    public boolean onContextItemSelected(MenuItem item) {    //快捷菜单事件
        switch(item.getItemId()){
            case CONTEXT_MENU_1:
                listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        i=position;
                    }
                });
                //Toast.makeText(this, "查看", Toast.LENGTH_LONG).show();
                for (Student student:students){
                    if (students.get(i).getName().equals(student.getName())) {   //得先点击一下再长按
                        intent.putExtra("name", student); //显示在第二个界面
                        intent.putExtra("bmi",bmi);
                    }
                }
                //startActivity(intent);
                startActivityForResult(intent, 1);
                return true;
            default:
                return false;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {   //activity的传值
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode){
            case 1:       //secondActivity
                if(resultCode== RESULT_OK){
                    Toast.makeText(getApplicationContext(), data.getData().toString()+ data.getStringExtra("name"),Toast.LENGTH_SHORT).show();//得到第二个界面的值
                }
            case 2:       //ThirdActivity
                if(resultCode== RESULT_OK){
                    /*list3  =new ArrayList<String>();
                    list3 = (List<String>)data.getSerializableExtra("name");

                    ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list3);
                    spinner.setAdapter(adapter4);
                    adapter4.notifyDataSetChanged();*/
                }
        }
    }

    public static List<Activity> activityList = new LinkedList();  //关闭的list
    public void exit()    //退出
    {
        for(Activity act:activityList)
        {
            act.finish();
        }
        System.exit(0);
    }

    public void add() {      //添加方法
        String hobby = "";
        int count = 0;
        list2.add(editText.getText().toString());
        stu.setName(editText.getText().toString());  //姓名
        stu.setHeight(editText2.getText().toString());  //身高
        stu.setWeight(editText3.getText().toString());   //体重
        if (radioButton.isChecked())   //性别
            stu.setSex(radioButton.getText().toString());
        else
            stu.setSex(radioButton2.getText().toString());
        for (CheckBox checkbox : checkBoxList) {    //爱好
            if (checkbox.isChecked() && count == 0) {
                hobby = hobby + checkbox.getText().toString();
                count++;
            } else if (checkbox.isChecked())
                hobby = hobby + "，" + checkbox.getText().toString();
        }
        stu.setHobby(hobby);
        stu.setProfession(spinner.getSelectedItem().toString());  //专业
        students.add(stu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shiyan1);

        editText = (EditText) findViewById(R.id.editText);   //姓名
        editText2 = (EditText) findViewById(R.id.editText2);  //身高
        editText3 = (EditText) findViewById(R.id.editText3);   //体重

        button = (Button) findViewById(R.id.button);    //关闭
        button2 = (Button) findViewById(R.id.button2);    //添加
        button3 = (Button) findViewById(R.id.button6);    //计算

        listview = (ListView) findViewById(R.id.listview);
        listview2 = (ListView) findViewById(R.id.listview);

        spinner = (Spinner) findViewById(R.id.spinner);

        radioButton = (RadioButton) findViewById(R.id.radioButton);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);

        checkBox=(CheckBox)findViewById(R.id.checkBox);
        checkBox2=(CheckBox)findViewById(R.id.checkBox2);
        checkBox3=(CheckBox)findViewById(R.id.checkBox3);

        checkBoxList = new ArrayList<CheckBox>();
        checkBoxList.add(checkBox);
        checkBoxList.add(checkBox2);
        checkBoxList.add(checkBox3);

        //editText2.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);
        //editText3.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);
        editText2.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {     //身高的限制
                if(keyCode>=7&&keyCode<=16||keyCode==56||keyCode==67){
                    return true;
                }
                else{
                    Toast.makeText(getApplicationContext(), "输入有误，请输入数字和字符“.”",Toast.LENGTH_SHORT).show();
                    return false;
                }
            }
        });
        editText3.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {     //体重的限制
                if(keyCode>=7&&keyCode<=16||keyCode==56||keyCode==67){
                    return true;
                }
                else{
                    Toast.makeText(getApplicationContext(), "输入有误，请输入数字和字符“.”",Toast.LENGTH_SHORT).show();
                    return false;
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                exit();  //退出
            }
        });
        shiyan1Activity.activityList.add(this);

        list = new ArrayList<String>();     //spinner的静态设值 ，专业list
        list.add("计算机");
        list.add("软件工程");
        list.add("物联网");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);   //adapter
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(0);   //设置默认选中“计算机”项

        list2 = new ArrayList<String>();   //listview的静态设值，名字list2
        //设置的几个固定的学生,他们的信息不变，与添加的学生无关
        list2.add("赵明");
        students.add(new Student("赵明","186","70","男","旅游，运动","物联网"));
        list2.add("徐玉峰");
        students.add(new Student("徐玉峰","170","55","男","旅游，运动，其他","计算机"));
        list2.add("姚泽昊");
        students.add(new Student("姚泽昊","167","70","男","其他","计算机"));
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list2);  //adapter2
        listview.setAdapter(adapter2);

        registerForContextMenu(listview);     //绑定菜单

        final ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list2);   //adapter3
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listview2.setAdapter(adapter3);
                    if(TextUtils.isEmpty(editText.getText())){
                        Toast.makeText(shiyan1Activity.this, "姓名为空不加入", Toast.LENGTH_SHORT).show();
                    }else {
                        add();
                        Toast.makeText(shiyan1Activity.this, "添加" +"\n"+ students.get(num).speak() +"\n"+ "到listview", Toast.LENGTH_SHORT).show();
                        num++;
                        adapter3.notifyDataSetChanged();  //动态刷新
                    }
            }
        });

        AdapterView.OnItemClickListener listViewListener = new AdapterView.OnItemClickListener() {    //左击名字事件
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String msg = String.valueOf(id);
                editText.setText(msg);
            }
        };
        listview.setOnItemClickListener(listViewListener);

        listview.setOnTouchListener(new View.OnTouchListener() {    //触摸listview事件
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Toast.makeText(shiyan1Activity.this, "触摸事件发生", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

        final Intent intent3 = new Intent("shiyan3.service");
        intent3.setPackage("com.example");
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent3.putExtra("name",editText.getText().toString());
                intent3.putExtra("height",editText2.getText().toString());
                intent3.putExtra("weight",editText3.getText().toString());
                //startService(intent3);
                bindService(intent3,connection,BIND_AUTO_CREATE);

                //unbindService(connection);

            }
        });

        /*final FragmentManager fm = getSupportFragmentManager();   //fragment
        final AFragment af = new AFragment();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.framelayout, af);
                ft.commit();
            }
        });*/

        //点击男
        /*radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {   //radiobutton的互斥
            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
                if(arg1){

                    radioButton2.setChecked(false);
                }
            }
        });
        //点击女
        radioButton2.setOnCheckedChangeListener(new  CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
                if(arg1){

                    radioButton.setChecked(false);
                }
            }
        });*/
    }
}
