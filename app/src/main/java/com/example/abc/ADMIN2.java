package com.example.abc;

        import androidx.annotation.NonNull;
        import androidx.annotation.RequiresApi;
        import androidx.appcompat.app.AlertDialog;
        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Build;
        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.google.firebase.database.ValueEventListener;

        import java.text.SimpleDateFormat;
        import java.util.ArrayList;
        import java.util.Date;

public class ADMIN2 extends AppCompatActivity {
    DatabaseReference ref;
    DatabaseReference dbStudent;
    DatabaseReference dbadmin;
    DatabaseReference dbAttendance;


    ArrayList Studentlist = new ArrayList();

    String date = new SimpleDateFormat("dd-mm-yy").format(new Date());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_d_m_i_n2);


        ref = FirebaseDatabase.getInstance().getReference();
        dbStudent = ref.child("Student");
        dbAttendance = ref.child("attendance");

    }
    public void AddTeacherButton(View v){
        Intent intent = new Intent(this,ADDTE.class);
        startActivity(intent);
    }
    public void AddStudentButton(View v) {
        Intent intent = new Intent(this, ADDST.class);
        startActivity(intent);
    }
    public void attendanceRecord(View v) {
        Intent intent = new Intent(this, AT_RECORD.class);
        startActivity(intent);
    }
    public void CreateAttendance(View v){



        dbStudent.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String sid,P1="-",P2="-",P3="-",P4="-",P5="-",P6="-",P7="-",P8="-";
                Attendance_sheet a = new Attendance_sheet(P1,P2,P3,P4,P5,P6,P7,P8);

                for (DataSnapshot dsp : dataSnapshot.getChildren()){
                    sid=dsp.child("sid").getValue().toString();
                    dbAttendance.child(date).child(sid).setValue(a);

                }
                Toast.makeText(getApplicationContext(),"successfully created "+date+"db",Toast.LENGTH_LONG).show();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),"something worng",Toast.LENGTH_LONG).show();


            }
        });

    }
    public void logout(View v){
        Intent logout=new Intent(ADMIN2.this,LOGIN.class);
        logout.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(logout);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void changepassword(View view) {
        dbadmin=ref.child("Admin");

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("set your new password");
        final LayoutInflater inflater = this.getLayoutInflater();
        View add_manu_layout = inflater.inflate(R.layout.changepassword,null);
        final EditText password= add_manu_layout.findViewById(R.id.newpass);
        alertDialog.setView(add_manu_layout);





    }


}