package com.example.myapplication;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import java.io.File;


public class PreviewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test8_1_preview);
        this.setTitle("照片预览");

        ImageView imageView = findViewById(R.id.image_view);
        String path = getIntent().getStringExtra("path");
        if(path != null){
            imageView.setImageURI(Uri.fromFile(new File(path)));
        }
    }
}
