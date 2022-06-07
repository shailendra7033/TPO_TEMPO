package co.tvs.tpo_tempo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class FaqsAdapter extends FirebaseRecyclerAdapter<FaqsModelToRetriveData,FaqsAdapter.FaqHolder> {

// constructor of adapter class .i.e main class of this
    // this basically brings data from firebase actually from model class and model class me firebase se atta hain

    public FaqsAdapter(@NonNull FirebaseRecyclerOptions<FaqsModelToRetriveData> options) {
        super(options);

    } // end of constructor

    @Override
    protected void onBindViewHolder(@NonNull FaqHolder faqHolder, int i, @NonNull FaqsModelToRetriveData faqsModelToRetriveData) {
        // use the getter method to feed the data to view
        faqHolder.txtAns.setText(faqsModelToRetriveData.getAnswer());
        faqHolder.txtQues.setText(faqsModelToRetriveData.getQuestion());



    }

    @NonNull
    @Override
    public FaqHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.faqs_single_row_view,parent,false);

        return new FaqHolder(view);
    }


    class FaqHolder extends RecyclerView.ViewHolder{
            TextView txtQues,txtAns;

         public FaqHolder(@NonNull View itemView) {
             super(itemView);
             txtQues= itemView.findViewById(R.id.txt_faqs_ques_single_page);
             txtAns=itemView.findViewById(R.id.txt_faqs_answer_single_page);
         }// constructor of FaqHolder

     }// end of nested class FaqHolder

}// end of Adapter Class
