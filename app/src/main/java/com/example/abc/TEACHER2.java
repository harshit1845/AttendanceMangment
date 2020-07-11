package com.example.abc;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TEACHER2 extends AppCompatActivity {
    String item;
    String message;

    private static long back_pressed;
    String date = new SimpleDateFormat("dd-mm-yyyy").format(new Date());

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_e_a_c_h_e_r2);

        Spinner spinner2 = findViewById(R.id.spinner2);
        Bundle bundle1 = getIntent().getExtras();
        message = bundle1.getString("message");

       spinner2.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        List<String> categories = new ArrayList<String>();
        categories.add("CSE");
        categories.add("ME");
        categories.add("CE");
        categories.add("E");
        categories.add("D");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter);


    }

    public void takeAttendanceButton(View v) {
        Bundle basket = new Bundle();
        basket.putString("class_selected",item);
        basket.putString("tid",message);

        Intent i = new Intent(this,take_attendance.class);
        i.putExtras(basket);
        startActivity(i);
    }
    public void previous_records(View v){
        Bundle basket = new Bundle();
        basket.putString("class_selected",item);
        basket.putString("tid",message);

        Intent i = new Intent(this,techer_attendance_sheet.class);
        i.putExtras(basket);
        startActivity(i);


    }
    public void logoutTeacher(View v){
        Intent logoutTeacher=new Intent(TEACHER2.this,LOGIN.class);
        logoutTeacher.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(logoutTeacher);

    }
    @Override
    public void onBackPressed() {
        if (back_pressed + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            finish();
        } else {
            Toast.makeText(getBaseContext(), "press once again to exit", Toast.LENGTH_SHORT).show();
            back_pressed = System.currentTimeMillis();
        }


    }

}
