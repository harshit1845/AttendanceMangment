package com.example.abc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class LOGIN extends AppCompatActivity  implements AdapterView.OnItemSelectedListener  {
    EditText username,password;
    String item;
    String userid,pass;
    DatabaseReference ref;
    String dbpassword;
    ProgressDialog mDialog;
    Bundle basket;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l_o_g_i_n);
        username = findViewById(R.id.edittext1);
        password = findViewById(R.id.edittext2);
        username = findViewById(R.id.edittext1);
        password = findViewById(R.id.edittext2);
        Spinner spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        List<String> categories = new ArrayList<String>();
        categories.add("Admin");
        categories.add("Teacher");
        categories.add("Student");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
    }
    @Override
    public void onItemSelected(AdapterView<?>parent, View view,
                               int position, long id) {
    }
    public void onNothingSelected(AdapterView<?> arg0) {
    }
    public void onButtonclick(View v){
        userid = username.getText().toString();
        pass = password.getText().toString();
        mDialog=new ProgressDialog(this);
        mDialog.setMessage("please Wait..."+userid);
        mDialog.setTitle("Loding");
        mDialog.show();
        basket = new Bundle();
        basket.putString("message",userid);
        ref = FirebaseDatabase.getInstance().getReference();
        DatabaseReference dbuser = ref.child(item).child(userid);
        dbuser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String dbchild = null;
                try {
                    if (item == "Admin") {
                        mDialog.dismiss();
                        dbpassword = dataSnapshot.getValue(String.class);
                        verify(dbpassword);
                    } else {
                        mDialog.dismiss();
                        if (item == "Student") {
                            dbchild = "spass";
                        }
                        if (item == "Teacher") {
                            dbchild = "tpass";
                        }
                        dbpassword = dataSnapshot.child(dbchild).getValue(String.class);
                        verify(dbpassword);
                    }
                }
                catch (Exception e)
                {
                    Toast.makeText(LOGIN.this,"Something went worng",Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),"Something went worng",Toast.LENGTH_LONG).show();
            }
        });
    }
    public void verify(String dbpassword){
        if (userid.isEmpty()){
            Toast.makeText(getApplicationContext(),"User name can not be empty",Toast.LENGTH_LONG).show();
        }
        else
        if(item == "Teacher" && pass.equalsIgnoreCase(this.dbpassword)){
            mDialog.dismiss();
            Intent intent = new Intent(this,TEACHER2.class);
            intent.putExtras(basket);
            startActivity(intent);
        }
        else
        if(item == "Admin" && pass.equalsIgnoreCase(this.dbpassword)){
            mDialog.dismiss();
            Intent intent = new Intent(this,ADMIN2.class);
            intent.putExtras(basket);
            startActivity(intent);
        }
        else
        if(item == "Student" && pass.equalsIgnoreCase(this.dbpassword)){
            mDialog.dismiss();
            Intent intent = new Intent(this,STUDENT2.class);
            intent.putExtras(basket);
            startActivity(intent);
        }
        else
        if(! pass.equalsIgnoreCase(this.dbpassword)){
            Toast.makeText(getApplicationContext(),"UserId password is incorrect",Toast.LENGTH_LONG).show();
        }
    }

    }

