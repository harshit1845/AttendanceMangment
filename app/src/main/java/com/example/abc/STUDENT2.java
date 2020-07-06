package com.example.abc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.internal.SafeIterableMap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class STUDENT2 extends AppCompatActivity {

String message;
String date=new SimpleDateFormat("dd-MM-yyyy").format(new Date());
Toolbar mToolbar;
DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Teacher");
private static long back_pressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_t_u_d_e_n_t2);
        Bundle bundle = getIntent().getExtras();
        message = bundle.getString("message");
        TextView textView = findViewById(R.id.tv1);

        textView.setText("Wellcome: "+message);

    }

    public void viewAttendance(View v){
        Bundle basket = new Bundle();
        basket.putString("sid",message);
        Intent i = new Intent(this,student_attendance_sheet.class);
        i.putExtras(basket);
        startActivity(i);

    }
    public void logoutStudent(View v){

        Intent logoutStudent=new Intent(STUDENT2.this,LOGIN.class);
        logoutStudent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(logoutStudent);

    }

    @Override
    public void onBackPressed() {
        if (back_pressed + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            finish();
        }
        else {
            Toast.makeText(getBaseContext(), "press once again to exit", Toast.LENGTH_SHORT).show();
            back_pressed=System.currentTimeMillis();
        }
    }
}
