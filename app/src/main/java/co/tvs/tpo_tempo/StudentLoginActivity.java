package co.tvs.tpo_tempo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class StudentLoginActivity extends AppCompatActivity {
    // declaring variables
    TextView txtSignUp;
    EditText txtEmail,txtPassword;
    Button btnLogin,btnResetPassword;
    FirebaseAuth loginAuth;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        //set the orientation Portrait
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // hooks
        txtSignUp=findViewById(R.id.txt_sign_up_student);
        txtEmail=findViewById(R.id.user_id);
        txtPassword=findViewById(R.id.edit_login_password);
        btnLogin=findViewById(R.id.btn_login);
        btnResetPassword=findViewById(R.id.btn_reset_password);

        // on click l on txt signup
        txtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(StudentLoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });  // end of on click l


        // on click l on login button
    btnLogin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String txt_email = txtEmail.getText().toString();
            String txt_password = txtPassword.getText().toString();

            if(TextUtils.isEmpty(txt_email) || TextUtils.isEmpty (txt_password)){
                Toast.makeText(StudentLoginActivity.this,"Empty credential.....!",Toast.LENGTH_SHORT).show();
            }else {
                loginUser(txt_email, txt_password);
            }
        }
    }); // end of login listener

        // on click L on Reset button
        btnResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StudentLoginActivity.this,ResetPasswordActivity.class);
                startActivity(intent);
            }
        });

    }// end of on create


    // method for logging in user
    private void loginUser(String email, String password) {
        loginAuth=FirebaseAuth.getInstance();
        loginAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(StudentLoginActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent intent=new Intent(StudentLoginActivity.this,Home.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(StudentLoginActivity.this, "Incorrect Credentials", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }



    /*
        #---------Already applied below method in MainActivity.java  --------#
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        loginAuth=FirebaseAuth.getInstance();
        FirebaseUser currentUser = loginAuth.getCurrentUser();
        if (currentUser != null) {
            Intent intent = new Intent(StudentLoginActivity.this, Home.class);
            startActivity(intent);
            finish();
        }
    } // end of on start
*/


}// end of class