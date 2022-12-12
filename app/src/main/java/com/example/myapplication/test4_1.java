package com.example.myapplication;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;
import android.util.Log;

public class test4_1 extends Activity {

    final int FLAG_MSG = 0x001;    //定义要发送的消息代码
    private ViewFlipper flipper;   //定义ViewFlipper
    private Message message;        //声明消息对象
    private Animation[] animation = new Animation[2];  //定义动画数组，为ViewFlipper指定切换动画



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test4_1);

        flipper = (ViewFlipper) findViewById(R.id.viewFlipper);  //获取ViewFlipper

        //初始化动画数组
        animation[0] = AnimationUtils.loadAnimation(this, R.anim.slide_in_right); //右侧平移进入动画
        animation[1] = AnimationUtils.loadAnimation(this, R.anim.slide_out_left); //左侧平移退出动画
        flipper.setInAnimation(animation[0]);   //为flipper设置图片进入动画效果
        flipper.setOutAnimation(animation[1]);  //为flipper设置图片退出动画效果

        message=Message.obtain();       //获得消息对象
        message.what=FLAG_MSG;  //设置消息代码
        handler.sendMessage(message); //发送消息
    }
    Handler handler = new Handler() {  //创建android.os.Handler对象
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == FLAG_MSG) {  //如果接收到的是发送的标记消息
                flipper.showPrevious();                  //示下一张图片
            }
            message=handler.obtainMessage(FLAG_MSG);   //获取要发送的消息
            handler.sendMessageDelayed(message, 3000);  //延迟3秒发送消息
        }
    };
}