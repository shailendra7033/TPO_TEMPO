package co.tvs.tpo_tempo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Home extends AppCompatActivity {
    Button btnLogOut;
    FirebaseAuth logOutAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // hooks
        btnLogOut=findViewById(R.id.btn_log_out);

        logOutAuth=FirebaseAuth.getInstance();
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logOutAuth.signOut();
                Intent intent=new Intent(Home.this,StudentLoginActivity.class);
                startActivity(intent);
            }
        });


    }
}