package com.example.abc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ADDTE extends AppCompatActivity {
    EditText Tname;
   EditText Tid,tpassword,Subject;
    String tname,tid,classname,tpass;
    Spinner classes;
    DatabaseReference databaseTeacher;


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
    public void addTeacher(View v){
        tname = Tname.getText().toString();
        tid = Tid.getText().toString();
        classname = classes.getSelectedItem().toString();
        tpass = tpassword.getText().toString();


        if(!(TextUtils.isEmpty(Tid.getText().toString()))){
            TE te = new TE(tname,tid,classname,tpass);
            databaseTeacher.child(tid).setValue(te);
            Toast.makeText(getApplicationContext(),"Teacher added successfully", Toast.LENGTH_LONG).show();
            finish();

        }else {
            Toast.makeText(getApplicationContext(),"fields cannot be empty",Toast.LENGTH_LONG).show();

        }

    }
    public void removeTeacher(View v) {
        if (!TextUtils.isEmpty(Tid.getText().toString())) {
            tid = Tid.getText().toString();
            databaseTeacher.child(tid).setValue(null);
            Toast.makeText(getApplicationContext(), "student remove successfully", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(getApplicationContext(), "id can not be empty", Toast.LENGTH_LONG).show();


        }
    }

}
