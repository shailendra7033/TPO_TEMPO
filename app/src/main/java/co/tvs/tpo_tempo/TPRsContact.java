package co.tvs.tpo_tempo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class TPRsContact extends AppCompatActivity {
    RecyclerView recyclerViewTpr;
    public TprAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tprs_contact);

        // hooks
        recyclerViewTpr=findViewById(R.id.recv_tpr_contact);
        recyclerViewTpr.setLayoutManager(new LinearLayoutManager(this));



        // path of Tpr contact in Firebase
        Query query= FirebaseDatabase.getInstance().getReference().child("TPRs").limitToLast(5);

        //firebase recyclerview retrieving the data from them
        FirebaseRecyclerOptions<TprsModelClassToReteriveData> options =
                new FirebaseRecyclerOptions.Builder<TprsModelClassToReteriveData>()
                        .setQuery(query, TprsModelClassToReteriveData.class)
                        .build();



// creating object of tpr adapter adapter
        adapter=new TprAdapter(options);
        recyclerViewTpr.setAdapter(adapter);



    }// on create end

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

}// class end