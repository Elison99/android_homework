package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button2_1=this.findViewById(R.id.button2_1);
        button2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, test2_1.class);
                startActivity(intent);
            }
        });
        Button button2_2=this.findViewById(R.id.button2_2);
        button2_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,test2_2.class);
                startActivity(intent);
            }
        });
        Button button3_1=this.findViewById(R.id.button3_1);
        button3_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,test3_1.class);
                startActivity(intent);
            }
        });

        Button button4_1=this.findViewById(R.id.button4_1);
        button4_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,test4_1.class);
                startActivity(intent);
            }
        });

        Button button5_1=this.findViewById(R.id.button5_1);
        button5_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,test5_1.class);
                startActivity(intent);
            }
        });
    }

    public void test6_1(View view) {
        Intent intent = new Intent(MainActivity.this,test6_1.class);
        startActivity(intent);
    }


    public void login_7_1(View view) {
        Intent intent = new Intent(MainActivity.this,test7_1.class);
        startActivity(intent);
    }

    public void login_8_1(View view) {
        Intent intent = new Intent(MainActivity.this,test8_1.class);
        startActivity(intent);
    }
}