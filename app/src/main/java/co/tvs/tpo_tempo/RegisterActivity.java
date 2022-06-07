package co.tvs.tpo_tempo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;


public class RegisterActivity extends AppCompatActivity {
    // declaring variables
    Button btnRegisterUser;
    EditText txtEmailRegister,txtPasswordRegister;
    TextView txtSignIn;
    FirebaseAuth regAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // hooks or connecting to xml id
        btnRegisterUser=findViewById(R.id.btn_register_user);
        txtEmailRegister=findViewById(R.id.edit_register_email);
        txtPasswordRegister=findViewById(R.id.edit_register_password);
        txtSignIn = findViewById(R.id.txt_sign_in_student);
        //firebase instance
        regAuth=FirebaseAuth.getInstance();

        // on click l on txt signin
        txtSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });  // end of on click l

        // on click L on Register button
        btnRegisterUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailRegister = txtEmailRegister.getText().toString();
                String registerPassword = txtPasswordRegister.getText().toString();

                if(TextUtils.isEmpty(emailRegister) || TextUtils.isEmpty (registerPassword)){
                    Toast.makeText(RegisterActivity.this,"Empty credential.....!",Toast.LENGTH_SHORT).show();
                }else {
                    registerUser(emailRegister,registerPassword);
                }
            } // overridden method
        });// end of on click l on register btn

    } // End on create

    public void registerUser(String emailRegister, String registerPassword) {
     regAuth.createUserWithEmailAndPassword(emailRegister,registerPassword).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
         @Override
         public void onComplete(@NonNull Task<AuthResult> task) {
             if(task.isSuccessful()){
                 DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
                 String userId = Objects.requireNonNull(regAuth.getCurrentUser()).getUid();
                 String email = regAuth.getCurrentUser().getEmail();
                 Personal user = new Personal("NA", "NA", email, "NA", "NA", "NA", "NA", "NA", "NA", "NA", "NA");
                 mDatabase.child("Users_Profile").child(userId).setValue(user);
                 Intent intent = new Intent(RegisterActivity.this,Home.class);
                 startActivity(intent);
                 finish();
             }else{
                 Toast.makeText(RegisterActivity.this, "Unsuccessful Try Again", Toast.LENGTH_SHORT).show();
             }
         }
     });
    }


}// end of class