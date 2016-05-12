package com.example.skilledanswers_d1.overflowmenu.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.skilledanswers_d1.overflowmenu.Model.PendingReviewModel;
import com.example.skilledanswers_d1.overflowmenu.R;

import java.util.ArrayList;

/**
 * Created by SkilledAnswers-D1 on 11-05-2016.
 */
public class PendingAdapter extends RecyclerView.Adapter<PendingAdapter.Holder> {
    private ArrayList<PendingReviewModel> pendingReviewModels=null;
    private Context  context=null;

    public PendingAdapter(ArrayList<PendingReviewModel> pendingReviewModels, Context context) {
        this.pendingReviewModels = pendingReviewModels;
        this.context = context;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View  view= LayoutInflater.from(parent.getContext()).inflate(R
        .layout.pending_review_row,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        PendingReviewModel model=pendingReviewModels.get(position);
        holder.textView.setText(""+model.get_productName());
        holder.imageView.setImageResource(model.get_productImage());

    }

    @Override
    public int getItemCount() {
        return pendingReviewModels.size();
    }

    protected class Holder extends RecyclerView.ViewHolder
    {
    ImageView imageView=null;
    TextView textView=null;
        public Holder(View itemView) {
            super(itemView);
            this.imageView=(ImageView)itemView.findViewById(R.id.pending_row_imageview);
            this.textView=(TextView)itemView.findViewById(R.id.pending_row_productName);
        }
    }
}
