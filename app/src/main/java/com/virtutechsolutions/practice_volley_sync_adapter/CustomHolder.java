package com.virtutechsolutions.practice_volley_sync_adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import java.util.List;

/**
 * Created by mallikarjuna on 20-04-2017.
 */

public class CustomHolder extends RecyclerView.Adapter<CustomHolder.View_Holder> {
    private  Context c;
    private List<Movie> list;
    boolean a=true;

    CustomHolder(Context c,List<Movie> list)
    {
        this.c=c;
        this.list=list;
    }


    class View_Holder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        CardView imageView2;
        TextView textView;
        TextView textView1;
        TextView textView2;

        public View_Holder(View itemView) {
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.movieimage);
            imageView2= (CardView) itemView.findViewById(R.id.cardview);
            textView= (TextView) itemView.findViewById(R.id.title);
            textView1= (TextView) itemView.findViewById(R.id.description);
            textView2= (TextView) itemView.findViewById(R.id.releasedate);
        }
    }
    @Override
    public View_Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate=LayoutInflater.from(c).inflate(R.layout.movie_list,null);
        return new View_Holder(inflate);
    }

    @Override
    public void onBindViewHolder(final View_Holder holder, int position) {

        final String Image_url="https://image.tmdb.org/t/p/w500"+list.get(position).getPosterPth();
        String Image_url1="https://image.tmdb.org/t/p/w500"+list.get(position).getBackdrop_path();

        Glide.with(c).load(Image_url1).asBitmap().into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {

                Drawable drawable=new BitmapDrawable(new BlurTransformation(c).transform(resource));

                holder.imageView2.setBackground(drawable);
            }
        });



        holder.textView.setText(list.get(position).getTitle());
        holder.textView1.setText(list.get(position).getOverView());
        holder.textView2.setText(list.get(position).getReleaseDate());
        Glide.with(c).load(Image_url).into(holder.imageView);


        holder.textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (a)
                {
                    holder.textView1.setLines(20);
                    holder.textView1.setMaxLines(20);
                    a=false;
                }
                else
                {
                    holder.textView1.setLines(3);
                    holder.textView1.setMaxLines(3);
                    a=true;
                }
            }
        });


        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               View view=LayoutInflater.from(c).inflate(R.layout.examplelay,null);
                ImageView imageView12= (ImageView) view.findViewById(R.id.exampleimage);
                Glide.with(c).load(Image_url).into(imageView12);

                AlertDialog alertDialog=new AlertDialog.Builder(c)
                        .setCancelable(false)
                        .setView(view)
                        .setPositiveButton("download", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .create()
                        ;

                alertDialog.show();
                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            }
        });

    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}
