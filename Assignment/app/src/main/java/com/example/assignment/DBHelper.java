package com.example.assignment;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION=1;

    // DBHelper 생성자로 관리할 DB 이름과 버전 정보를 받음
    public DBHelper(Context context){
        super(context, "studentdb", null, DATABASE_VERSION );
    }

    // DB를 새로 생성할 때 한 번 호출되는 함수
    @Override
    public void onCreate(SQLiteDatabase db) {
        String userSQL="CREATE TABLE tb_user (" +
                "id PRIMARY KEY," +
                " pw not null," +
                " name," +
                " phoneNum," +
                " address)";
        db.execSQL(userSQL);
    }

    // 버전 변경시마다 호출. 스키마 변경을 목적으로 사용
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(newVersion == DATABASE_VERSION){
            db.execSQL("drop table tb_user");
            onCreate(db);
        }
    }
}
