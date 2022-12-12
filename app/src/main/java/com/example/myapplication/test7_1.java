package com.example.myapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;

public class test7_1 extends AppCompatActivity {

    //获取SQLiteOpenHelper
    private TimeSQLiteOpenHelper timeSQLiteOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test7_1);

        ActionBar actionBar = getSupportActionBar();  // 获取ActionBar
        if (actionBar != null) {
            actionBar.setTitle("登陆并记录时间");  // 设置ActionBar的标题
            // actionBar.setSubtitle("请详细阅读");  // 副标题
            actionBar.setDisplayHomeAsUpEnabled(true);  // 设置返回按钮
        }

        //实例化TimeSQLiteOpenHelper，用来创建数据库
        timeSQLiteOpenHelper=new TimeSQLiteOpenHelper(test7_1.this,"db_Time",null,1);

        //初始化按钮为不可用
        Button login = findViewById(R.id.login);
        login.setEnabled(false);

        //给编辑框添加监听器，若为空则按钮不可用
        EditText edit_username = findViewById(R.id.editTextTextPersonName);
        EditText edit_password = findViewById(R.id.editTextTextPassword);
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            //若两文本框都不为空，则按钮可用
            @Override
            public void afterTextChanged(Editable s) {
                if (edit_password.getText().length() == 0 || edit_username.getText().length() == 0) {
                    login.setEnabled(false);
                } else {
                    login.setEnabled(true);
                }
            }
        };
        edit_username.addTextChangedListener(textWatcher);
        edit_password.addTextChangedListener(textWatcher);

        //登陆，将用户名传递给test_7_1_login，并将登陆时间写入数据库
        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //获取文本框的用户名密码，捆绑起来给intent
                String username = edit_username.getText().toString();
                String password = edit_password.getText().toString();
                Intent intent = new Intent(test7_1.this, test7_1_login.class);
                Bundle bundle = new Bundle();
                bundle.putCharSequence("username",username);
                bundle.putCharSequence("password",password);
                intent.putExtras(bundle);

                //获取当前时间
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");// HH:mm:ss
                Date date = new Date(System.currentTimeMillis());
                String time =simpleDateFormat.format(date);

                //将登陆时间写入数据库
                insertTime(timeSQLiteOpenHelper.getReadableDatabase(),time);

                //启动登陆后的界面
                startActivity(intent);
                edit_password.setText("");
            }


        });
    }

    //数据库insert方法
    private void insertTime(SQLiteDatabase sqLiteDatabase,String time)
    {
        ContentValues values = new ContentValues();
        values.put("loginTime",time);     //保存时间
        sqLiteDatabase.insert("Time",null,values);
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