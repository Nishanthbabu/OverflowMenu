package com.example.skilledanswers_d1.overflowmenu.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.skilledanswers_d1.overflowmenu.Model.PendingReviewModel;
import com.example.skilledanswers_d1.overflowmenu.Model.PublishedModel;
import com.example.skilledanswers_d1.overflowmenu.R;

import java.util.ArrayList;

/**
 * Created by SkilledAnswers-D1 on 11-05-2016.
 */
public class PublishedAdapter extends RecyclerView.Adapter<PublishedAdapter.Holder> {

    private ArrayList<PublishedModel> publishedModels=null;
    private Context context=null;

    public PublishedAdapter(ArrayList<PublishedModel> publishedModels, Context context) {
        this.publishedModels = publishedModels;
        this.context = context;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View  view= LayoutInflater.from(parent.getContext()).inflate(R
                .layout.published_row,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        PublishedModel model=publishedModels.get(position);
        holder.imageView.setImageResource(model.get_image());
        holder.textViewPname.setText(""+model.get_productName());
        holder.ratingBar.setRating(model.get_ratting());
        holder.textViewReview.setText(""+model.get_review());


    }

    @Override
    public int getItemCount() {
        return publishedModels.size();
    }

    protected class Holder extends RecyclerView.ViewHolder
    {
        ImageView imageView=null;
        TextView textViewPname=null;
        RatingBar ratingBar=null;
        TextView textViewReview=null;
        public Holder(View itemView) {
            super(itemView);
            this.imageView=(ImageView)itemView.findViewById(R.id.publishedRowImageview);
            this.textViewPname=(TextView)itemView.findViewById(R.id.publishedRowProductName);
            this.ratingBar=(RatingBar)itemView.findViewById(R.id.publishedRowratting);
            textViewReview=(TextView)itemView.findViewById(R.id.publishedRowReview);
        }
    }

}
