package com.example.saif.wallpaperxi;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.IOException;

public class Selecedwallpapers extends AppCompatActivity {

    ImageView imageView;
    LinearLayout linearLayout;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecedwallpapers);

        imageView=(ImageView)findViewById(R.id.image_selected);
        linearLayout=findViewById(R.id.selected_layout);
        btn=findViewById(R.id.btn_setwallpaer);

        Intent intent= getIntent();
        final String url = intent.getStringExtra("url");
        Picasso.get().load(url).into(imageView);

         final Target target=  new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());
                try {
                    wallpaperManager.setBitmap(bitmap);
                    Snackbar.make(linearLayout,"Wallpaper Set",Snackbar.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onBitmapFailed(Exception e, Drawable errorDrawable) {

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        };

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Picasso.get().load(url).into(target);
            }
        });

    }
}
