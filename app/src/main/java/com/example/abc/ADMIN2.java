package com.example.abc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ADMIN2 extends AppCompatActivity {

Button bt_adte,bt_adst,bt_gtattend,bt_atrecord,bt_cngpas,bt_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_d_m_i_n2);

        bt_adte = findViewById(R.id.btaddte);
        bt_adst = findViewById(R.id.btaddst);
        bt_gtattend = findViewById(R.id.btgtat);
        bt_atrecord = findViewById(R.id.btatrecord);
        bt_cngpas = findViewById(R.id.btcngpass);
        bt_logout = findViewById(R.id.btlogout);

        bt_adte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(ADMIN2.this,ADDTE.class);
                startActivity(it);

            }
        });

        bt_adst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(ADMIN2.this,ADDST.class);
                startActivity(it);

            }
        });
        bt_atrecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(ADMIN2.this,AT_RECORD.class);
                startActivity(it);

            }
        });
    }
}
