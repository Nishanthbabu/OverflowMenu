package com.example.skilledanswers_d1.overflowmenu.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.skilledanswers_d1.overflowmenu.Adapters.PublishedAdapter;
import com.example.skilledanswers_d1.overflowmenu.R;

/**
 * Created by SkilledAnswers-D1 on 11-05-2016.
 */
public class PublishedReview extends Fragment{
    private RecyclerView recyclerView=null;
    private RecyclerView.LayoutManager layoutManager=null;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.recycleview_fragment,container,false);
        Toast.makeText(getActivity(),"here frag2",Toast.LENGTH_LONG).show();
        recyclerView=(RecyclerView)view.findViewById(R.id.recycleviewFragmentID);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        layoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        System.out.println("llllllllllllllllllllllllllll----"+PendingReview.publishedModels);
        PublishedAdapter adapter=new PublishedAdapter(PendingReview.publishedModels,getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        adapter.notifyDataSetChanged();
    }
}
