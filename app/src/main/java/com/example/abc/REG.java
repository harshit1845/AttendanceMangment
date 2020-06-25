package com.example.abc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class REG extends AppCompatActivity {
    EditText edtusername,edtemail, edtpassword,edtconfrimpassword;
    Button btnsub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r_e_g);
        edtusername = findViewById(R.id.edt_username);
        edtemail = findViewById(R.id.edt_email);
        edtpassword = findViewById(R.id.edt_password);
        edtconfrimpassword = findViewById(R.id.edt_confirmpassword);
        btnsub = findViewById(R.id.btn_sub);

        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(REG.this,LOGIN.class);
                startActivity(i);

            }
        });
    }
}
