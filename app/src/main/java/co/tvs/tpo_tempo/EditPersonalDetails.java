package co.tvs.tpo_tempo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditPersonalDetails extends AppCompatActivity {

    EditText txtName, txtRegNo,txtCourse, txtBranch, txtDob;
    Button btnSaveDetails;
    ImageView goBackToProfile;
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_personal_details);


        // hooks, connecting to xml
        txtName = findViewById(R.id.edit_txt_name_personal);
        txtRegNo = findViewById(R.id.edit_txt_reg_no_personal);
        txtCourse = findViewById(R.id.edit_txt_course_personal);
        txtBranch = findViewById(R.id.edit_txt_branch_personal);
        txtDob = findViewById(R.id.edit_txt_dob_personal);
        btnSaveDetails = findViewById(R.id.btn_save_personal);
        goBackToProfile = findViewById(R.id.go_back_personal_to_profile);

        goBackToProfile.setOnClickListener(v -> {
            onBackPressed();
        });


        // in the xml file of personal details i have used scroll bar so that we can put the details and that will be scrollable
        //on click listener on save button
        btnSaveDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //now storing the input into string  which is entered by user
                // we should ideally check whether the input given is in appropriate format, like it should not empty, registration number should contain digits.....
                String name = txtName.getText().toString();
                String regNo = txtRegNo.getText().toString();
                String course = txtCourse.getText().toString();
                String branch = txtBranch.getText().toString();
                String dob = txtDob.getText().toString();
                savePersonalDetails(name,regNo,course,branch,dob);
                Toast.makeText(EditPersonalDetails.this,"!!Saved!!",Toast.LENGTH_SHORT).show();
                onBackPressed();
            }
        });  // end of on click l on save button
    }

    // method to save details on realtime firebase database
    private void savePersonalDetails(String name, String regNo,String course,String branch, String dob) {
        mDatabase= FirebaseDatabase.getInstance().getReference();
        Personal user = new Personal(name,regNo,course,branch,dob);
        String userId = firebaseAuth.getCurrentUser().getUid();
        mDatabase.child("Users_Profile").child(userId).setValue(user);
    }
}