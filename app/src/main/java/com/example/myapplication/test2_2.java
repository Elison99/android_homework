package com.example.myapplication;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class test2_2 extends Activity {
    @RequiresApi(api = Build.VERSION_CODES.O)
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.test2_2);
        Button button=this.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        final DatePicker datePicker = findViewById(R.id.date_picker);
        datePicker.updateDate(2022,10,11);
        datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                //合成时间
                Calendar calendar = Calendar.getInstance();
                calendar.set(i,i1,i2);
                //时间格式化
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
                //Toast.makeText(getApplicationContext(),"当前选择时间："+simpleDateFormat.format(calendar.getTime()),Toast.LENGTH_SHORT).show();

            }
        });
        //重置时间
        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker.updateDate(2022,10,11);
                Toast.makeText(getApplicationContext(),"已经恢复到默认起始时间！",Toast.LENGTH_SHORT).show();
            }
        });
        //确认时间
        Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(datePicker.getYear(),datePicker.getMonth(),datePicker.getDayOfMonth());
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
                Toast.makeText(getApplicationContext(),"您的生日："+simpleDateFormat.format(calendar.getTime()),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
