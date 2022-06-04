package co.tvs.tpo_tempo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudentDetails extends AppCompatActivity {
    public Button btn_resume,btn_personal,btn_projects,btn_academics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);
    btn_personal=findViewById(R.id.btn_personalDetails);
    btn_academics=findViewById(R.id.btn_academics);
    btn_projects=findViewById(R.id.btn_Project);
    btn_resume=findViewById(R.id.btn_resume);


    btn_personal.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(StudentDetails.this,PersonalDetails.class);
            startActivity(intent);
        }
    });


    }
}