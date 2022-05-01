package com.example.damxat.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.damxat.Model.Xat;
import com.example.damxat.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;


public class RecyclerXatAdapter extends RecyclerView.Adapter<RecyclerXatAdapter.ViewHolder> {
    //Properties

    private ArrayList<Xat> arrayList;
    private Context context;

    private final int MSG_TYPE_RIGHT=0;
    private final int MSG_TYPE_LEFT=1;
    FirebaseUser firebaseUser;

    //Constructor
    public RecyclerXatAdapter(ArrayList<Xat> arrN, Context c){
        this.arrayList = arrN;
        this.context = c;
    }
    //App LifeCycle
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType==MSG_TYPE_RIGHT){
            // Inflates the layout for this fragments "items"
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_xat_right, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        }else{
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_xat_left, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {

        //holder.txtUsername.setText(arrayList.get(i).getMessage());
        //Add data to the layout elements
        holder.txtXatMessage.setText(String.valueOf(arrayList.get(i).getMessage()));


    }

    @Override
    //This item count the arrayList size
    public int getItemCount() {
        return arrayList.size();
    }

    //Set item view of txtXatMessage
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtXatMessage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtXatMessage= itemView.findViewById(R.id.txtXatMessage);
        }
    }

    @Override
    public int getItemViewType(int position){
        //Get current user information
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if(arrayList.get(position).getSender().equals(firebaseUser.getUid())){
            return MSG_TYPE_RIGHT;
        }else{
            return MSG_TYPE_LEFT;
        }
    }
}

