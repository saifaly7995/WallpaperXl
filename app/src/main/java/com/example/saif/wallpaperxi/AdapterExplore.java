package com.example.saif.wallpaperxi;

import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterExplore  extends RecyclerView.Adapter<AdapterExplore.HolderforExplore>{

     private List<ListItem> listItems;
    private Context context;


    public AdapterExplore(List<ListItem> listItems, Context context) {
        this.listItems=listItems;
        this.context=context;

    }


    @NonNull
    @Override
    public HolderforExplore onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.layout_for_explore,parent,false);

        return new HolderforExplore(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderforExplore holder, int position) {

        final ListItem lt= listItems.get(position);

        //yahan PICASO KA KAM h image ka
        Picasso.get().load(lt.getUrl()).into(holder.imgView);

        holder.imgView.setOnClickListener(new View.OnClickListener() {
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

    public class HolderforExplore extends RecyclerView.ViewHolder{

        TextView textView;
        ImageView imgView;

        public HolderforExplore(@NonNull View itemView) {
            super(itemView);

            imgView=itemView.findViewById(R.id.img_explore);
            //image aega picasso se
        }
    }
}


