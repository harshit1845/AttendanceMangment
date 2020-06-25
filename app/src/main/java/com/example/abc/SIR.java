package com.example.abc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class SIR extends AppCompatActivity {
   RelativeLayout really1;
   Button btsig;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_i_r);

        really1 = findViewById(R.id.rellay1);
        btsig = findViewById(R.id.bt_sig);

        btsig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SIR.this,LOGIN.class);
                startActivity(i);
            }
        });
    }
}
