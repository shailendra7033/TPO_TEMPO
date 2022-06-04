package co.tvs.tpo_tempo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Home extends AppCompatActivity {
    Button btnLogOut,btnProfile;
    FirebaseAuth logOutAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // hooks
        btnLogOut=findViewById(R.id.btn_log_out);
        btnProfile=findViewById(R.id.btn_profile);

        logOutAuth=FirebaseAuth.getInstance();


        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logOutAuth.signOut();
                Intent intent=new Intent(Home.this,StudentLoginActivity.class);
                startActivity(intent);
                finish();
            }
        }); // end of on click l of btnlogout

        // on click l on Profile button
    btnProfile.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(Home.this,StudentDetails.class);
            startActivity(intent);
//            finish();

        }
    }); // end of on click l of profile btn

    }  // end of on create method
} // end of class