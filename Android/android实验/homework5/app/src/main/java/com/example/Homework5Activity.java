package com.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Homework5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.absolute);//绝对布局能通过定义坐标来摆放位置，实现比较方便，但不能很好地使用各种大小的屏幕
//        setContentView(R.layout.constraint);//约束布局实现十分方便，各个控件都能建立一定的联系，只要和屏幕边缘建立联系就能很好地适应各种大小的屏幕
//        setContentView(R.layout.grid);//网格布局比表格灵活，元素可以占用多个网格，实现简单，只要设置好网格大小，元素占比即可，看起来很工整
//        setContentView(R.layout.linear);//线性布局需要在里面再放几个线性布局以实现行的效果，看起来很不美观
//        setContentView(R.layout.relative);//相对布局比较灵活，主要是和屏幕边缘建立联系，能更好地适应不同大小的屏幕
//        setContentView(R.layout.table);//表格布局对于列数相同的情况实现比较方便，但当列数不同时，控件就会变得很不美观，当列数过大时，这点尤其体现，还要设置layout_weight，才能手动调整按钮宽度
    }
}
