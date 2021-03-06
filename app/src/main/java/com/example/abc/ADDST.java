package com.example.abc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ADDST extends AppCompatActivity {
    EditText Sname;
    EditText Sid,spassword;
    String sname,sid,spass,classname;
    Spinner classes;
    DatabaseReference databaseStudent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_d_d_s_t);

        databaseStudent = FirebaseDatabase.getInstance().getReference();

        Sname = findViewById(R.id.et_1);
        Sid = findViewById(R.id.et_2);
        classes = findViewById(R.id.sp1);
        spassword = findViewById(R.id.et_3);


    }

    public void addStudent(View v){

        if(!(TextUtils.isEmpty(Sid.getText().toString()))){

            sname = Sname.getText().toString();
            sid = Sid.getText().toString();
            classname = classes.getSelectedItem().toString();
            spass = spassword.getText().toString();

            ST st = new ST(sname,sid,classname,spass);
            databaseStudent.child(sid).setValue(st);
            Toast.makeText(getApplicationContext(),"student added successfully",Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(getApplicationContext(),"fields cannot be empty",Toast.LENGTH_LONG).show();


        }

    }

    public void removeStudent(View v) {
        if (!TextUtils.isEmpty(Sid.getText().toString())) {
            sid = Sid.getText().toString();
            databaseStudent.child(sid).setValue(null);
            Toast.makeText(getApplicationContext(),"student remove successfully",Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(getApplicationContext(),"id can not be empty",Toast.LENGTH_LONG).show();


        }
    }
}