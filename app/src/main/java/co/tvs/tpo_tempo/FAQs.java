package co.tvs.tpo_tempo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class FAQs extends AppCompatActivity {
    RecyclerView recycleV;
   public FaqsAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faqs);

        // connect to xml
        recycleV =findViewById(R.id.recv_faqs);

        // recycler view setting layout manager
        recycleV.setLayoutManager(new LinearLayoutManager(this));


        // taking path of firebase to retrive data
        Query query=FirebaseDatabase.getInstance().getReference().child("FAQs").limitToLast(10);

        //firebase recyclerview retrieving the data from them
        FirebaseRecyclerOptions<FaqsModelToRetriveData> options =
                new FirebaseRecyclerOptions.Builder<FaqsModelToRetriveData>()
                        .setQuery(query, FaqsModelToRetriveData.class)
                        .build();


// reating object of Faq adapter
        adapter=new FaqsAdapter(options);
        recycleV.setAdapter(adapter);





    }  // end of on create


    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }







}// end of class FAQs