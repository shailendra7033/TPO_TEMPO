package co.tvs.tpo_tempo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ResetPasswordActivity extends AppCompatActivity {
    EditText emailForReset;
    Button btnSendLink;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        //hooks
        emailForReset=findViewById(R.id.email_for_reset_link);
        btnSendLink=findViewById(R.id.btn_send_link_reset_password);

        // on click L on btnSendLink for reset Password
        btnSendLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=emailForReset.getText().toString();
                if(TextUtils.isEmpty(email)){
                    Toast.makeText(ResetPasswordActivity.this,"Empty Email.....!",Toast.LENGTH_SHORT).show();
                }else {
                    sendLink(email);
                }
            }
        });// end of on click
    } // end of on create

   public void sendLink(String email) {
        auth = FirebaseAuth.getInstance();


        auth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(ResetPasswordActivity.this, "Link Sent", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(ResetPasswordActivity.this,StudentLoginActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                }); // end of auth.send........
    } // end of send link method
}//end of class