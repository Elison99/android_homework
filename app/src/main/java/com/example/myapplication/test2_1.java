package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;


public class test2_1 extends Activity implements CompoundButton.OnCheckedChangeListener {
    private ArrayList<String> choises = new ArrayList<>();
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.test2_1);
        Button button2=this.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Button button3=this.findViewById(R.id.button3);
        CheckBox checkBox = this.findViewById(R.id.checkBox);
        CheckBox checkBox2 = this.findViewById(R.id.checkBox2);
        CheckBox checkBox3 = this.findViewById(R.id.checkBox3);
        CheckBox checkBox4 = this.findViewById(R.id.checkBox4);
        //设置CheckBox监听器
        checkBox.setOnCheckedChangeListener(this);
        checkBox2.setOnCheckedChangeListener(this);
        checkBox3.setOnCheckedChangeListener(this);
        checkBox4.setOnCheckedChangeListener(this);
        final TextView resultText = this.findViewById(R.id.textView_result);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder sb = new StringBuilder();
                for(int i=0;i<choises.size();i++)
                {
                    if(i==(choises.size()-1))
                    {
                        sb.append(choises.get(i));
                    }
                    else
                    {
                        sb.append(choises.get(i)+"、");
                    }
                }
                //显示选择结果
                if(sb.length()==0)
                {
                    resultText.setText("请选择至少一项答案");
                }
                else
                {
                    resultText.setText("您选择了："+sb+"。");
                }
            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if(b)
        {
            choises.add(compoundButton.getText().toString().trim());
        }
        else
        {
            choises.remove(compoundButton.getText().toString().trim());
        }
    }
}
