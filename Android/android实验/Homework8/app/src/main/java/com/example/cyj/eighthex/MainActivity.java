package com.example.cyj.eighthex;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //声明各个按钮
    private Button createButton;
    private Button insertButton;
    private Button updateButton;
    private Button queryBtn;
    private Button deleteBtn;
    private Button ModifyBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化界面
        initView();
        //监听事件
        setListener();
    }

    //初始化界面
    private void initView() {
        createButton = (Button) findViewById(R.id.createDatabase);
        insertButton = (Button) findViewById(R.id.insert);
        updateButton = (Button) findViewById(R.id.updateDatabas);
        queryBtn  = (Button) findViewById(R.id.query);
        deleteBtn = (Button) findViewById(R.id.delete);
        ModifyBtn = (Button) findViewById(R.id.update);
    }

    //监听事件
    private void setListener() {
        createButton.setOnClickListener(new CreateListener());
        updateButton.setOnClickListener(new UpdateListener());
        insertButton.setOnClickListener(new InsertListener());
        ModifyBtn.setOnClickListener(new ModifyListener());
        queryBtn.setOnClickListener(new QueryListener());
        deleteBtn.setOnClickListener(new DeleteListener());
    }

    //数据库的创建
    private class CreateListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            MyDBOpenHelper dbHelper = new MyDBOpenHelper(MainActivity.this,"test",null,1);
            SQLiteDatabase db =dbHelper.getReadableDatabase();
            Toast.makeText(MainActivity.this,"创建数据库成功",Toast.LENGTH_LONG).show();
        }
    }

    //数据插入
    private class InsertListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            MyDBOpenHelper dbHelper = new MyDBOpenHelper(MainActivity.this,"test",null,1);
            SQLiteDatabase db =dbHelper.getWritableDatabase();
            String sql="insert into staff(id,name,sex,department,salary) values(1,'Tom','male','computer',5400)";
            db.execSQL(sql);
            String sql2="insert into staff(id,name,sex,department,salary) values(2,'Einstein','male','computer',4800)";
            db.execSQL(sql2);
            String sql3="insert into staff(id,name,sex,department,salary) values(3,'Lily','female','computer',5000)";
            db.execSQL(sql3);
            String sql4="insert into staff(id,name,sex,department,salary) values(4,'Warner','male',null,null)";
            db.execSQL(sql4);
            String sql5="insert into staff(id,name,sex,department,salary) values(5,'Napoleon','male',null,null)";
            db.execSQL(sql5);
            Toast.makeText(MainActivity.this,"插入数据成功!",Toast.LENGTH_LONG).show();
        }
    }

    //数据的删除
    private class DeleteListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            MyDBOpenHelper dbHelper = new MyDBOpenHelper(MainActivity.this,"test",null,1);
            SQLiteDatabase db =dbHelper.getReadableDatabase();
            String sql1 = "delete from staff where id =1";
            db.execSQL(sql1);
            Toast.makeText(MainActivity.this,"删除数据成功!",Toast.LENGTH_LONG).show();
        }
    }

    //数据的更新
    private class ModifyListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            MyDBOpenHelper dbHelper = new MyDBOpenHelper(MainActivity.this,"test",null,1);
            SQLiteDatabase db =dbHelper.getWritableDatabase();
            String sql = "update staff set name = 'YuJie' where id = 3";
            db.execSQL(sql);
            Toast.makeText(MainActivity.this,"数据库更新成功",Toast.LENGTH_LONG).show();
        }
    }

    //数据库版本的更新
    private class UpdateListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            MyDBOpenHelper dbHelper = new MyDBOpenHelper(MainActivity.this,"test",null,2);
            SQLiteDatabase db =dbHelper.getReadableDatabase();
            Toast.makeText(MainActivity.this,"数据库版本更新成功",Toast.LENGTH_LONG).show();
        }
    }

    //数据的查询
    private class QueryListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            MyDBOpenHelper dbHelper = new MyDBOpenHelper(MainActivity.this,"test",null,1);
            SQLiteDatabase db =dbHelper.getReadableDatabase();
            //参数1：表名
            // 参数2：要想显示的列
            // 参数3：where子句
            // 参数4：where子句对应的条件值
            // 参数5：分组方式
            // 参数6：having条件
            // 参数7：排序方式
            Cursor cursor = db.query("staff", new String[]{"id","name","sex","department","salary"}, null, null, null, null, null,null);
            while(cursor.moveToNext()){
                String id = cursor.getString(cursor.getColumnIndex("id"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String sex = cursor.getString(cursor.getColumnIndex("sex"));
                String department = cursor.getString(cursor.getColumnIndex("department"));
                String salary = cursor.getString(cursor.getColumnIndex("salary"));
                System.out.println("查询------->" + "ID："+id+" "+"姓名："+name+" "+"性别："+sex+" "+"所在部门："+department+" "+"工资："+salary);
            }
            Toast.makeText(MainActivity.this,"查询数据库成功",Toast.LENGTH_LONG).show();
            db.close();
        }
    }
}