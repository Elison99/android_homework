package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

public class TimeSQLiteOpenHelper extends SQLiteOpenHelper {
    //新建表的SQL语句
    final String CREATE_TABLE_SQL="CREATE TABLE Time(id integer primary key autoincrement,loginTime VARCHAR(30))";

    //构造方法
    public TimeSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建Time表
        db.execSQL(CREATE_TABLE_SQL);
    }

    @Override
    //版本更新
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.i("时间","版本更新"+oldVersion+"-->"+newVersion);

    }
}
