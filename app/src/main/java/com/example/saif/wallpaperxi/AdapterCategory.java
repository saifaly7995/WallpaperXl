package com.example.saif.wallpaperxi;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;


public class AdapterCategory extends RecyclerView.Adapter<AdapterCategory.Holderforstore>{

    //here we declare attributes for the values we get from database and set in recyclerview
    private List<ListItem> listItems;
    private Context context;


    public AdapterCategory(List<ListItem> listItems, Context context) {
        this.listItems=listItems;
        this.context=context;


    }


    @NonNull
    @Override
    public AdapterCategory.Holderforstore onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.layout_for_category,parent,false);



        return new AdapterCategory.Holderforstore(view);
    }




    @Override
    public void onBindViewHolder(@NonNull AdapterCategory.Holderforstore holder, int position) {


        final ListItem lt= listItems.get(position);


        Picasso.get().load(lt.getUrl()).into(holder.imgViewcat);

        holder.imgViewcat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, lt.getName()+" clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(v.getContext(),Selecedwallpapers.class);
                intent.putExtra("url",lt.getUrl());
                v.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class Holderforstore extends RecyclerView.ViewHolder{


        public ImageView imgViewcat;


        public Holderforstore(@NonNull View itemView) {
            super(itemView);

            imgViewcat=(ImageView)itemView.findViewById(R.id.img_cat);


        }

    }


}


