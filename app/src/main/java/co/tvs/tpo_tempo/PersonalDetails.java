package co.tvs.tpo_tempo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PersonalDetails extends AppCompatActivity {
    EditText txtName, txtRegNo, txtDob;
    Button btnSaveDetails;
    String nameOfStudent,regNo,dob;
    FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_details);

        // hooks, connecting to xml

        txtName=findViewById(R.id.edit_txt_name_personal);
        txtRegNo=findViewById(R.id.edit_txt_reg_no_personal);
        txtDob=findViewById(R.id.edit_txt_dob_personal);
        btnSaveDetails=findViewById(R.id.btn_save_personal);





        // in the xml file of personal details i have used scrool baar so that we can put the details and that will be scrollable
        //on click listener on save button
        btnSaveDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //now storing the input into string  which is entered by user
                // we should ideally check whether the input given is in appropriate format, like it should not empty, registration number should contain digits.....
                nameOfStudent=txtName.getText().toString();
                regNo=txtRegNo.getText().toString();
                dob=txtDob.getText().toString();
                savePersonalDetails(nameOfStudent,regNo,dob);
            }
        });  // end of on click l on save button











    } // end of onCreate method


    // method to save details on realtime firebase database
    private void savePersonalDetails(String name, String regNo, String dob) {
        mDatabase=FirebaseDatabase.getInstance().getReference();
        Personal user= new Personal(name,regNo,dob);
        String userId=firebaseAuth.getCurrentUser().getUid();
        mDatabase.child("users").child(userId).setValue(user);
    }


}// end of class PersonalDetails