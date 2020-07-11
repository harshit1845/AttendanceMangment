package com.example.abc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class techer_attendance_sheet extends AppCompatActivity {
    ListView listView;
    String teacher_id,class_selected;
    EditText date;
    ArrayList Userlist = new ArrayList<>();
    ArrayList Studentlist = new ArrayList<>();

    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
    DatabaseReference dbAttendance;
    DatabaseReference dbStudent;
    String required_date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_techer_attendance_sheet);

        listView = findViewById(R.id.list);
        date = findViewById(R.id.date);
        Bundle bundle1=getIntent().getExtras();;
        class_selected = bundle1.getString("class_selected");
        teacher_id = bundle1.getString("tid");

    }
    public void viewlist(View v){

        Userlist.clear();
        dbStudent=ref.child("student");
        dbStudent.orderByChild("classes").equalTo(class_selected).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dsp : dataSnapshot.getChildren()){
                    Userlist.add(dsp.child("sid").getValue().toString());

                }
                display_list(Userlist);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),"worng",Toast.LENGTH_LONG).show();

            }
        });
    }
    public void display_list(final ArrayList userlist){

        Studentlist.clear();
        required_date=date.getText().toString();
        dbAttendance=ref.child("attendance");
        Studentlist.add("  SID     "+"Status" +  "  peroid ");
        for (Object sid : userlist){
            dbAttendance.child(required_date).child(sid.toString()).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                        String p1 = dsp.getValue().toString();
                        if ((p1.equals("A / "+teacher_id)) || (p1.equals("P /"+teacher_id))) {
                            Studentlist.add(dataSnapshot.getKey().toString() +"     "+p1.substring(0,1) +"   "+dsp.getChildren());

                        }
                    }
                    list(Studentlist);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(getApplicationContext(),"worng",Toast.LENGTH_LONG).show();


                }
            });
        }
    }
    public void list(ArrayList studentlist){
        ArrayAdapter<String>adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,android.R.id.text1,studentlist);
    }
}
