package com.example.skilledanswers_d1.overflowmenu.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.skilledanswers_d1.overflowmenu.Adapters.ViewpagerAdapter;
import com.example.skilledanswers_d1.overflowmenu.R;

/**
 * Created by SkilledAnswers-D1 on 11-05-2016.
 */
public class MyReviewsPager extends Fragment {
    private String[] title={"Pending","Published"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.my_review_pager,container,false);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.my_review_Viewpager);
        setupViewPager(viewPager);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.my_review_pagerTab);


        tabLayout.setupWithViewPager(viewPager);



        return view;
    }

    private  void setupViewPager(ViewPager viewPager) {
        ViewpagerAdapter adapter = new ViewpagerAdapter(getChildFragmentManager());
        adapter.addFrag(new PendingReview(), title[0]);
        adapter.addFrag(new PublishedReview(),title[1]);
        viewPager.setAdapter(adapter);


    }

}
