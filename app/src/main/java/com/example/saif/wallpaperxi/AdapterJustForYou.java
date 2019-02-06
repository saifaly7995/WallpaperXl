package com.example.saif.wallpaperxi;

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

public class AdapterJustForYou  extends RecyclerView.Adapter<AdapterJustForYou.Holderr> {

    private List<ListItem> listItems;
    private Context context;

    public AdapterJustForYou(List<ListItem> listItems, Context context) {
        this.listItems=listItems;
        this.context=context;

    }




    @NonNull
    @Override
    public Holderr onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.layout_just_for_you, parent, false);

        return new Holderr(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holderr holder, int position) {

        final ListItem lt= listItems.get(position);


        Picasso.get().load(lt.getUrl()).into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
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

    public class Holderr extends RecyclerView.ViewHolder {

        ImageView imageView;

        public Holderr(@NonNull View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.img_jfy);
        }
    }
}



