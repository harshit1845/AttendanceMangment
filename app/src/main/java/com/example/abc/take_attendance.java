package com.example.abc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class take_attendance extends AppCompatActivity {
    String teacher_id;
    String class_selected;
    Spinner period;
    String periodno;
    ArrayList<String> selectedItem;
    ArrayList<String> nonselectedItem;

    ArrayList<String> ul;
    ListView listview;
    private ArrayAdapter adapter;
    ArrayList Userlist = new ArrayList<>();
    ArrayList Username = new ArrayList<>();

    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
    DatabaseReference dbAttendance;
    String date = new SimpleDateFormat("dd-mm-yyyy").format(new Date());




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_attendance);

        period = findViewById(R.id.sp3);

        selectedItem = new ArrayList<String>();

        TextView classname = findViewById(R.id.tv2);
        classname.setText("CSE");
        Bundle bundle1 = getIntent().getExtras();
        class_selected = bundle1.getString("class_selected");
        teacher_id = bundle1.getString("tid");

        classname.setText(class_selected);

        DatabaseReference dbuser = ref.child("Student");

        dbuser.orderByChild("classes").equalTo(class_selected).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    Userlist.add(dsp.child("sid").getValue().toString());
                    Username.add(dsp.child("sname").getValue().toString());
                }

                OnStart(Userlist);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),"somthing want wrong",Toast.LENGTH_LONG).show();


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    public void  OnStart(ArrayList<String> userlist) {
        nonselectedItem = userlist;
        ListView chl = findViewById(R.id.checkable_list);
        chl.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        ArrayAdapter<String> aa = new ArrayAdapter<>(this,R.layout.checkable_list_layout,R.id.txt_title,userlist);
        chl.setAdapter(aa);
        chl.setOnItemClickListener((parent, view,position,id) {
            String selectedItem = ((TextView) view).getText().toString();
            if (selectedItem.contains(selectedItem))
                selectedItem.remove(selectedItem);
            else
                selectedItem.add(selectedItem);

        });
    }
    public void showSelectedItem(View view) {
        String setItems = "";
        periodno = period.getSelectedItem().toString();
        if (periodno.equals("select period")) {
            Toast.makeText(this,"select a class",Toast.LENGTH_LONG).show();

        }
        else {
            ref = FirebaseDatabase.getInstance().getReference();

            dbAttendance = ref.child("attendance").child(date);

            for (String item : selectedItem) {
                Toast.makeText(this,"Attendance create Successfully",Toast.LENGTH_SHORT).show();
                nonselectedItem.remove(item);
                dbAttendance.child(item).child(periodno).setValue("P" + "/" + teacher_id);
                if (setItems == "")
                    setItems = item;
                    else
                     setItems += "/" + item;

            }

            for (String item : nonselectedItem) {
                Toast.makeText(this,"Attendance create Successfully",Toast.LENGTH_SHORT).show();
                dbAttendance.child(item).child(periodno)
            }

        }
    }
}
