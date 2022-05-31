package co.tvs.tpo_tempo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 3000;
    private FirebaseAuth auth;

    //variables
    Animation top_animation,bottom_animation;
    ImageView image;
    TextView logo;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set the orientation Portrait
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //animations calling
        top_animation = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottom_animation = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        //hooks
        image = findViewById(R.id.image_main);
        logo = findViewById(R.id.text_main);

        image.setAnimation(bottom_animation);
        logo.setAnimation(top_animation);

        // Firebase Instance
        auth = FirebaseAuth.getInstance();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                FirebaseUser User = auth.getCurrentUser();
                if(User != null){
                    //there is some user logged in
                    startActivity(new Intent(MainActivity.this,Home.class));
                }else{
                    //no user login
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                }
                finish();
            }
        },SPLASH_SCREEN);
    }
}