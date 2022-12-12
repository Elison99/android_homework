package com.example.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class test7_1_login extends AppCompatActivity {

    //获取SQLiteOpenHelper
    private TimeSQLiteOpenHelper timeSQLiteOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test7_1_login);
        Toast.makeText(test7_1_login.this,"登陆成功！",Toast.LENGTH_SHORT).show();

        //实例化TimeSQLiteOpenHelper，用来创建数据库
        timeSQLiteOpenHelper=new TimeSQLiteOpenHelper(test7_1_login.this,"db_Time",null,1);

        //获取上一个Activity传递来的intent，并将用户名显示在TextView
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        String username=bundle.getString("username");
        TextView textView=findViewById(R.id.username_7_1);
        textView.setText(username+"~");

        //获取列表视图
        ListView listView= findViewById(R.id.time_list);

        //点击查询数据库里记录的时间
        Button select_time=findViewById(R.id.select_time);
        select_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //查询所有
                Cursor cursor = timeSQLiteOpenHelper.getReadableDatabase().query("Time",null,null,null,null,null,null);

                //将查询结果存入map，再将map放入resultList
                ArrayList<Map<String,String>> resultList = new ArrayList<Map<String,String>>();
                while(cursor.moveToNext())
                {
                    Map<String,String> map = new HashMap<String, String>();
                    map.put("id",cursor.getString(0));
                    map.put("time",cursor.getString(1));
                    resultList.add(map);
                }

                //将查询的结果显示到ListView中
                if(resultList==null||resultList.size()==0)
                {
                    Toast.makeText(test7_1_login.this,"很遗憾，没有相关记录",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    //先将resultList放入适配器
                    SimpleAdapter simpleAdapter = new SimpleAdapter(test7_1_login.this,resultList,
                            R.layout.test7_1_time,
                            new String[]{"id","time"},new int[]{
                            R.id.textView11,R.id.textView12});

                    //给listView设置适配器
                    listView.setAdapter(simpleAdapter);
                }
            }
        });
    }

    protected void onDestroy()
    {
        super.onDestroy();
        if(timeSQLiteOpenHelper!=null)
        {
            timeSQLiteOpenHelper.close();//关闭数据库连接
        }
    }

}