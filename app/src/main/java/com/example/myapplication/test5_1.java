package com.example.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class test5_1 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test5_1);

        ActionBar actionBar = getSupportActionBar();  // 获取ActionBar
        if (actionBar != null) {
            actionBar.setTitle("登陆");  // 设置ActionBar的标题
            // actionBar.setSubtitle("请详细阅读");  // 副标题
            actionBar.setDisplayHomeAsUpEnabled(true);  // 设置返回按钮
        }


        Button login = findViewById(R.id.login);
        login.setEnabled(false);

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


        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String username = edit_username.getText().toString();
                String password = edit_password.getText().toString();
                Intent intent = new Intent(test5_1.this, test5_1_login.class);
                Bundle bundle = new Bundle();
                bundle.putCharSequence("username",username);
                bundle.putCharSequence("password",password);
                intent.putExtras(bundle);
                startActivity(intent);
                edit_password.setText("");
            }


        });
    }
   /*
   @Override            //重写ActionBar左上角的返回键监听器
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/

}