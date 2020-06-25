package com.example.abc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FIRST extends AppCompatActivity {
    Button btadmin,btteacher,btstudent,btinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_i_r_s_t);
        btadmin = findViewById(R.id.buttonAdmin);
        btteacher = findViewById(R.id.buttonteacher);
        btstudent = findViewById(R.id.buttonstudent);
        btinfo = findViewById(R.id.buttoninfo);

        btadmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(FIRST.this,ADMIN.class);
                startActivity(i);

            }
        });
        btteacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(FIRST.this,TEACHER.class);
                startActivity(it);
            }
        });
        btstudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent is = new Intent(FIRST.this,STUDENT.class);
                startActivity(is);
            }
        });

    }
}
