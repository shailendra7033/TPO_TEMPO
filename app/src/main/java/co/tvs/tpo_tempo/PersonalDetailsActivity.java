package co.tvs.tpo_tempo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class PersonalDetailsActivity extends AppCompatActivity {
    FloatingActionButton editPersonalDetailsBtn;
    TextView txtNamePersonal,txtRegNoPersonal,txtEmailPersonal,txtCoursePersonal,
            txtBranchPersonal,txtDobPersonal,txtLinkedInPersonal,txtSkypePersonal,
            txtGithubPersonal,txtAddressPersonal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_details);

        editPersonalDetailsBtn = findViewById(R.id.edit_personal_details_btn);
        txtNamePersonal = findViewById(R.id.txt_name_personal);
        txtRegNoPersonal = findViewById(R.id.txt_reg_no_personal);
        txtEmailPersonal = findViewById(R.id.txt_email_personal);
        txtCoursePersonal = findViewById(R.id.txt_course_personal);
        txtBranchPersonal = findViewById(R.id.txt_branch_personal);
        txtDobPersonal = findViewById(R.id.txt_dob_personal);
//        txtLinkedInPersonal = findViewById(R.id.txt_linkedin_personal);
//        txtSkypePersonal = findViewById(R.id.txt_skype_personal);
//        txtGithubPersonal = findViewById(R.id.txt_github_personal);
//        txtAddressPersonal = findViewById(R.id.txt_address_personal);

        // ----------------------- Firebase Access --------------------------- //
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        String userId = firebaseAuth.getCurrentUser().getUid();
        String userEmail = firebaseAuth.getCurrentUser().getEmail();
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("Users_Profile").child(userId);



        // Set email
        txtEmailPersonal.setText(userEmail);

        // -------------- //
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String name = Objects.requireNonNull(snapshot.child("name").getValue()).toString();
                String regNo = Objects.requireNonNull(snapshot.child("regNo").getValue()).toString();
                String course = Objects.requireNonNull(snapshot.child("course").getValue()).toString();
                String branch = Objects.requireNonNull(snapshot.child("branch").getValue()).toString();
                String dob = Objects.requireNonNull(snapshot.child("dob").getValue()).toString();
//                String linkedIn = Objects.requireNonNull(snapshot.child("linkedin").getValue()).toString();
//                String skypeId = Objects.requireNonNull(snapshot.child("skype").getValue()).toString();
//                String github = Objects.requireNonNull(snapshot.child("github").getValue()).toString();
//                String address = Objects.requireNonNull(snapshot.child("address").getValue()).toString();
                txtNamePersonal.setText(name);
                txtRegNoPersonal.setText(regNo);
                txtCoursePersonal.setText(course);
                txtBranchPersonal.setText(branch);
                txtDobPersonal.setText(dob);

//                if(course.equals("NA")){
//                    txtCoursePersonal.setVisibility(View.INVISIBLE);
//                }else{
//                    txtCoursePersonal.setText(course);
//                }
//
//                if(branch.equals("NA")){
//                    txtBranchPersonal.setVisibility(View.INVISIBLE);
//                }else{
//                    txtBranchPersonal.setText(branch);
//                }
//
//                if(dob.equals("NA")){
//                    txtDobPersonal.setVisibility(View.INVISIBLE);
//                }else{
//                    txtDobPersonal.setText(dob);
//                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(PersonalDetailsActivity.this,error.toString(),Toast.LENGTH_SHORT).show();
            }
        });


        editPersonalDetailsBtn.setOnClickListener(v -> {
            Intent intent=new Intent(PersonalDetailsActivity.this, EditPersonalDetails.class);
            startActivity(intent);
        });

    } // end of onCreate method

}// end of class PersonalDetails