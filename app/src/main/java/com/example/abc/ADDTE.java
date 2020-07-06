package com.example.abc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toolbar;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ADDTE extends AppCompatActivity {
    EditText Tname;
   EditText Tid,tpassword,Subject;
    String tname,tid,classname,tpass;
    Spinner classes;
    DatabaseReference databaseTeacher;
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_d_d_t_e);
        databaseTeacher = FirebaseDatabase.getInstance().getReference("Teacher");

        Tname = findViewById(R.id.et_1);
        Tid = findViewById(R.id.et_2);
        classes = findViewById(R.id.sp1);
        Subject = findViewById(R.id.et_3);
        tpassword = findViewById(R.id.et_4);
        getSupportActionBar().setTitle("Add/remove Teacher");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
    public void ADDTEACHER(View v){

    }

}
