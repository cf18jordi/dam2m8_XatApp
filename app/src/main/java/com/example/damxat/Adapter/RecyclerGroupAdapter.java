package com.example.damxat.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;


import com.example.damxat.Model.XatGroup;
import com.example.damxat.R;
import com.example.damxat.Views.Fragments.XatFragment;

import java.util.ArrayList;



public class RecyclerGroupAdapter extends RecyclerView.Adapter<RecyclerGroupAdapter.ViewHolder> {
    //Properties
    private ArrayList<XatGroup> arrayList;
    private Context context;

    //Constructor
    public RecyclerGroupAdapter(ArrayList<XatGroup> arrN, Context c){
        this.arrayList = arrN;
        this.context = c;
    }
    //App LifeCycle
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Inflates the layout fot this fragment
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_group, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }
    //Adds data to the layout elements defined in viewHolder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.recGroupName.setText(arrayList.get(position).getName());

        //If item are clicked
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.itemGroup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Bundle Properties
                        Bundle bundle = new Bundle();
                        bundle.putString("group", arrayList.get(position).getName());
                        bundle.putString("type", "xatgroup");
                        XatFragment detailFragment = new XatFragment();
                        detailFragment.setArguments(bundle);

                        AppCompatActivity app = (AppCompatActivity) view.getContext();
                        app.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, detailFragment).commit();
                    }
                });
            }
        });
    }

    //This element gets arrayList size
    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    //ViewHolder Properties
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView recGroupName;
        ConstraintLayout itemGroup;

        //Define items to variables
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recGroupName = itemView.findViewById(R.id.recGroupName);
            itemGroup = itemView.findViewById(R.id.itemGroup);
        }
    }
}

