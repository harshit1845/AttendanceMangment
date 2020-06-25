package com.example.abc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class LOGIN extends AppCompatActivity {
   RelativeLayout rellay1,rellay2;
   Button btlog,btsin,btfp;
   Handler handler = new Handler();
   Runnable runnable = new Runnable() {
       @Override
       public void run() {
           rellay1.setVisibility(View.VISIBLE);
           rellay2.setVisibility(View.VISIBLE);

       }
   };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l_o_g_i_n);

        rellay1 = findViewById(R.id.rellay1);
        rellay2 = findViewById(R.id.rellay2);
        btlog = findViewById(R.id.bt_log);
        btsin = findViewById(R.id.bt_sin);
        btfp = findViewById(R.id.bt_fp);
        btlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(LOGIN.this,FIRST.class);
                startActivity(i);
            }
        });
        btsin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LOGIN.this,SIR.class);
            }
        });

        handler.postDelayed(runnable,1000);

    }
}
