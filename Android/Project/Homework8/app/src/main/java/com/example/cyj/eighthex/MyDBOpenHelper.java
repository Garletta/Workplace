package com.example.cyj.eighthex;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyDBOpenHelper extends SQLiteOpenHelper {
      public MyDBOpenHelper( Context context,String name,SQLiteDatabase.CursorFactory factory, int version) {
          super(context, name, factory, version);
      }

      @Override
      public void onCreate(SQLiteDatabase db) {
          String sql =  "create table staff(id integer  PRIMARY KEY AUTOINCREMENT ,name text,sex text,department text,salary float)";
          Log.i("this", "create Database------------->");
          db.execSQL(sql);
      }

      @Override
      public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
          Log.i("this", "update Database------------->");
      }
}