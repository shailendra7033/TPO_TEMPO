package co.tvs.tpo_tempo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class TprAdapter extends FirebaseRecyclerAdapter<TprsModelClassToReteriveData,TprAdapter.TprHolder> {


    public TprAdapter(@NonNull FirebaseRecyclerOptions<TprsModelClassToReteriveData> options) {
        super(options);
    }

    //--->>>>On bind method--->>>>
    @Override
    protected void onBindViewHolder(@NonNull TprHolder tprHolder, int i, @NonNull TprsModelClassToReteriveData tprsModelClassToReteriveData) {
        tprHolder.tprName.setText(tprsModelClassToReteriveData.getName());
        tprHolder.tprBranch.setText(tprsModelClassToReteriveData.getBranch());
        tprHolder.tprPhone.setText(tprsModelClassToReteriveData.getPhone());
        tprHolder.tprLinkedin.setText(tprsModelClassToReteriveData.getLinkedin());
    }


    // On create--------->>>>>>>>
    @NonNull
    @Override
    public TprHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.tprs_single_row_page,parent,false);
        return new TprHolder(view);
    }




    // don't forget to extend holder class to viewHolder
   class TprHolder extends RecyclerView.ViewHolder {
        TextView tprName,tprPhone,tprBranch,tprLinkedin;
       public TprHolder(@NonNull View itemView) {
           super(itemView);

           tprName=itemView.findViewById(R.id.txt_tpr_name);
           tprLinkedin=itemView.findViewById(R.id.txt_tpr_linkedin);
           tprBranch=itemView.findViewById(R.id.txt_tpr_branch);
           tprPhone=itemView.findViewById(R.id.txt_tpr_phone);
       }// constructor of tpr holder

   }// end of tprHolder class


}// end of adapter tpr
