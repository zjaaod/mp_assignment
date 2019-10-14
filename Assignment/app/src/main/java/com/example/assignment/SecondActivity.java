package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    EditText idView;
    EditText pwView;
    EditText nameView;
    EditText phoneView;
    EditText addressView;
    Button signUp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        setTitle("회원가입");

        /*
        idView = (EditText) findViewByid(R.id.addId);
        pwView = (EditText) findViewByid(R.id.addPw);
        nameView = (EditText) findViewByid(R.id.addName);
        phoneView = (EditText) findViewByid(R.id.addPhone);
        addressView = (EditText) findViewByid(R.id.addAddress);
        signUp = (Button) findViewById(R.id.btnSignUp2);
        */
        Button btnNewActivity = (Button) findViewById(R.id.btnBack);
        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void onClick(View v) {
        String id = "idView.getText().toString()";
        String pw = "pwView.getText().toString()";
        String name = "nameView.getText().toString()";
        String phone = "phoneView.getText().toString()";
        String address = "addressView.getText().toString()";

        if(id == null || id.equals("")){
            Toast t = Toast.makeText(this, "id는 필수값입니다.", Toast.LENGTH_SHORT);
            t.show();
        }
        if(pw == null || pw.equals("")){
            Toast t = Toast.makeText(this, "pw는 필수값입니다.", Toast.LENGTH_SHORT);
            t.show();
        }
        else{
            DBHelper helper = new DBHelper(this);
            SQLiteDatabase db = helper.getWritableDatabase();
            db.execSQL("insert into tb_user (id,pw,name,phone,address) values (?,?,?,?,?)",
                    new String[] {id,pw,name,phone,address});
            db.close();

            finish();
        }

    }
}



