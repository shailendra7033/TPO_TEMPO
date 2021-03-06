package co.tvs.tpo_tempo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    // declaring variables

    Button btnStudentLogin,btnInstituteLogin;
    private FirebaseAuth loginAuth;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //set the orientation Portrait
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // connecting to xml file using id
        btnStudentLogin=findViewById(R.id.btn_student_login);
        btnInstituteLogin=findViewById(R.id.btn_institute_login);

        // set on click listener on button
        btnStudentLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // using intent to start new activity
                Intent intent=new Intent(LoginActivity.this,StudentLoginActivity.class);
                startActivity(intent);
            }
        });   // end of on click listener on student login btn

        // On click listener on institute button
        btnInstituteLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,InstituteLoginActivity.class);
                startActivity(intent);
            }
        }); //end of on click listener


    }  // end on on create method

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        loginAuth=FirebaseAuth.getInstance();
        FirebaseUser currentUser = loginAuth.getCurrentUser();
        if (currentUser != null) {
            Intent intent = new Intent(LoginActivity.this, Home.class);
            startActivity(intent);
        }
    } // end of on start

} // end of class