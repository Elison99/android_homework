package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class test6_1 extends AppCompatActivity {

    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String info = intent.getStringExtra("info");
            TextView textView7=findViewById(R.id.textView7);
            textView7.setText(info);
            Toast.makeText(context,"收到了全局广播~"+info,Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test6_1);

        ActionBar actionBar = getSupportActionBar();  // 获取ActionBar
        if (actionBar != null) {
            actionBar.setTitle("广播");  // 设置ActionBar的标题
            // actionBar.setSubtitle("请详细阅读");  // 副标题
            actionBar.setDisplayHomeAsUpEnabled(true);  // 设置返回按钮
        }

        //注册广播接收器
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("global_broad_cast");
        registerReceiver(mBroadcastReceiver,intentFilter);

    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        unregisterReceiver(mBroadcastReceiver);
    }

    public void sendGlobalBroadCast(View view) {
        //发送全局广播
        Intent intent = new Intent();
        intent.setAction("global_broad_cast");
        intent.putExtra("info","来自zpr：要听妈妈的话~~");
        sendBroadcast(intent);
    }

}