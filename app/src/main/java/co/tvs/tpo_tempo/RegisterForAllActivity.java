package co.tvs.tpo_tempo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class RegisterForAllActivity extends AppCompatActivity {
    // declaring variables
    Button btnRegisterUser;
    EditText txtEmailRegister,txtPasswordRegister;
    FirebaseAuth regAuth;
    String emailRegister,registerPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_for_all);

        // hooks or connecting to xml id
        btnRegisterUser=findViewById(R.id.btn_register_user);
        txtEmailRegister=findViewById(R.id.edit_register_email);
        txtPasswordRegister=findViewById(R.id.edit_register_password);
//firebase instance
        regAuth=FirebaseAuth.getInstance();

        // on click L on Register button
        btnRegisterUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                emailRegister=txtEmailRegister.getText().toString();
                registerPassword=txtPasswordRegister.getText().toString();

                    registerUser(emailRegister,registerPassword);
               

            } // overridden method
        });// end of on click l on register btn

    } // End on create

 public void registerUser(String emailRegister, String registerPassword) {
     regAuth.createUserWithEmailAndPassword(emailRegister,registerPassword).addOnCompleteListener(RegisterForAllActivity.this, new OnCompleteListener<AuthResult>() {
         @Override
         public void onComplete(@NonNull Task<AuthResult> task) {
             if(task.isSuccessful()){

                 Intent intent =new Intent(RegisterForAllActivity.this,Home.class);

                 startActivity(intent);
                 finish();
             }else{
                 Toast.makeText(RegisterForAllActivity.this, "Unsuccessfull Try Again", Toast.LENGTH_SHORT).show();
             }
         }
     });
    }


}// end of class