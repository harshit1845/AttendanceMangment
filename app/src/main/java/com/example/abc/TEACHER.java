package com.example.abc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TEACHER extends AppCompatActivity {
    Button btlog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_e_a_c_h_e_r);
        btlog = findViewById(R.id.bt_log);
        btlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent it = new Intent(TEACHER.this,TEACHER2.class);
                 startActivity(it);

            }
        });
    }
}
