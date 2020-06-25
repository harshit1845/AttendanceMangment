package com.example.abc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class STUDENT extends AppCompatActivity {
    Button btlog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_t_u_d_e_n_t);
        btlog = findViewById(R.id.bt_log);
        btlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent is = new Intent(STUDENT.this,STUDENT2.class);
                startActivity(is);

            }
        });

    }
}
