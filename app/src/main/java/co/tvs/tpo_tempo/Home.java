package co.tvs.tpo_tempo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Home extends AppCompatActivity {
    Button btnLogOut,btnFaqs,btnTprs,btnProfile;
    FirebaseAuth logOutAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // hooks
        btnLogOut=findViewById(R.id.btn_log_out);
        btnProfile=findViewById(R.id.btn_profile);
        btnFaqs=findViewById(R.id.btn_faqs_home);
        btnTprs=findViewById(R.id.btn_tpr_contact);

        logOutAuth=FirebaseAuth.getInstance();


        btnLogOut.setOnClickListener(v -> {
            logOutAuth.signOut();
            Intent intent=new Intent(Home.this,StudentLoginActivity.class);
            startActivity(intent);
            finish();
        }); // end of on click l on logout


        // on click l on Faqs
        btnFaqs.setOnClickListener(v -> {
            Intent intent=new Intent(Home.this,FAQs.class);
            startActivity(intent);
        });  // end of faqs button


        // on click l on Profile button
        btnProfile.setOnClickListener(v -> {
            Intent intent = new Intent(Home.this, StudentDetails.class);
            startActivity(intent);
        }); // end of on click l of profile btn

        // on click tprs
        btnTprs.setOnClickListener(v -> {
            Intent intent=new Intent(Home.this,TPRsContact.class);
            startActivity(intent);
        });

    }  // end of on create method
} // end of class