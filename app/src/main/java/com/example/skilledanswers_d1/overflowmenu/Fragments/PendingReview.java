package com.example.skilledanswers_d1.overflowmenu.Fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.skilledanswers_d1.overflowmenu.Adapters.PendingAdapter;
import com.example.skilledanswers_d1.overflowmenu.Model.PendingReviewModel;
import com.example.skilledanswers_d1.overflowmenu.Model.PublishedModel;
import com.example.skilledanswers_d1.overflowmenu.R;
import com.example.skilledanswers_d1.overflowmenu.RecyclerItemClickListener;

import java.util.ArrayList;

/**
 * Created by SkilledAnswers-D1 on 11-05-2016.
 */
public class PendingReview extends Fragment {
    private RecyclerView recyclerView=null;
    private LinearLayout  linearLayout=null;
    ////
    private RecyclerView.LayoutManager layoutManager=null;
    ///// dummy data
    private String[] pname={"Frame with collapsable glass and light","Camara with high resolution","Hand made painting"};
    private int[] PImage={R.drawable.frame,R.drawable.camara,R.drawable.paint};
    ///////////
    ArrayList<PendingReviewModel> pendingReviewModels=new ArrayList<>();
    public static ArrayList<PublishedModel> publishedModels=new ArrayList<>();
    private void setDummyData()
    {
        for(int i=0;i<pname.length;i++)
        {
            PendingReviewModel model=new PendingReviewModel();
            model.set_productImage(PImage[i]);
            model.set_productName(pname[i]);
            pendingReviewModels.add(model);
        }
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.recycleview_fragment,container,false);
        recyclerView=(RecyclerView)view.findViewById(R.id.recycleviewFragmentID);
        linearLayout=(LinearLayout)view.findViewById(R.id.recycleviewFragmentLinearLayoutID);
        //////
        layoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        setDummyData();
        final PendingAdapter pendingAdapter=new PendingAdapter(pendingReviewModels,getActivity());
        recyclerView.setAdapter(pendingAdapter);
        recyclerView.setHasFixedSize(true);
        /////////////////////////////////////////////////////////////////////////////
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, final int position) {
                final Dialog dialog=new Dialog(getActivity());
                dialog.setContentView(R.layout.review_dilog1);
                dialog.setTitle("Add Review");
                dialog.setCanceledOnTouchOutside(false);
                final TextInputEditText inputEditText=(TextInputEditText)dialog.findViewById(R.id.reviewDilogEdittext);
                final TextView textViewrateShow=(TextView)dialog.findViewById(R.id.reviewDilogHowMuchLike) ;
                RatingBar ratingBar=(RatingBar)dialog.findViewById(R.id.reviewDilogRatting);
                Button  buttonsave1=(Button)dialog.findViewById(R.id.reviewDilogNextButton);
                final Button  buttoncancle1=(Button)dialog.findViewById(R.id.reviewDilogCancelButton);
                final PublishedModel publishedModel=new PublishedModel();
                ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                        switch ((int) rating)
                        {
                            case 1: textViewrateShow.setText("Hate it");
                                publishedModel.set_ratting((int) rating);
                                break;
                            case 2: textViewrateShow.setText("bad");
                                publishedModel.set_ratting((int) rating);
                                break;
                            case 3: textViewrateShow.setText("ok ok");
                                publishedModel.set_ratting((int) rating);
                                break;
                            case 4: textViewrateShow.setText("Good");
                                publishedModel.set_ratting((int) rating);
                                break;
                            case 5:textViewrateShow.setText("Loved it");
                                publishedModel.set_ratting((int) rating);
                        }
                    }
                });
                buttoncancle1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                buttonsave1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        publishedModel.set_review(inputEditText.getText().toString());
                        publishedModel.set_productName(pendingReviewModels.get(position).get_productName());
                        publishedModel.set_image(pendingReviewModels.get(position).get_productImage());
                        publishedModels.add(publishedModel);
                        pendingReviewModels.remove(position);
                        layoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
                        recyclerView.setLayoutManager(layoutManager);
                        PendingAdapter adapter=new PendingAdapter(pendingReviewModels,getActivity());
                        recyclerView.setAdapter(adapter);
                        recyclerView.setHasFixedSize(true);
                        adapter.notifyDataSetChanged();
                        dialog.dismiss();

                    }
                });

                dialog.show();

            }
        }));
        return view;
    }
}
