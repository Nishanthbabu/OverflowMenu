package com.example.skilledanswers_d1.overflowmenu.Fragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.skilledanswers_d1.overflowmenu.R;


public class MyAccount extends Fragment {
    private ImageView profilePic=null;
    private TextView profileName=null;
    private TextView phNo=null;
    private TextView emailID=null;
    /////
    private TextView myTopOrderTextview=null;
    private TextView myOrderViewAllOrder=null;
    ////
    private TextView mywallettextview=null;
    ////////
    private TextView myReviewsViewAll=null;
    /////
    private TextView myTopAddress=null;
    private TextView myAddressViewAll=null;
    /////
    private TextView notification=null;
    private TextView accountSettings=null;
    private TextView logout=null;
    //////////////////////////////////////////////////////////////
    private ImageView settingPen=null;
    Toolbar toolbar=null;
    private Fragment fragment=null;
    /////////


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_my_account, container, false);
        ///// toolbar stuff
         toolbar = (Toolbar)getActivity().findViewById(R.id.toolbar);

        profilePic=(ImageView)view.findViewById(R.id.fragmentMyAccount_profilePicID);
        profileName=(TextView)view.findViewById(R.id.fragmentMyAccount_profileNameID);
        phNo=(TextView)view.findViewById(R.id.fragmentMyAccount_phnoID);
        emailID=(TextView)view.findViewById(R.id.fragmentMyAccount_emailID);
        myTopOrderTextview=(TextView)view.findViewById(R.id.fragmentMyAccount_presentOrdersID);
        myOrderViewAllOrder=(TextView)view.findViewById(R.id.fragmentMyAccount_ViewAllORdersID);
        mywallettextview=(TextView)view.findViewById(R.id.fragmentMyAccount_walletAmountID);
        myReviewsViewAll=(TextView)view.findViewById(R.id.fragmentMyAccount_reviewID);
        myTopAddress=(TextView)view.findViewById(R.id.fragmentMyAccount_myAddressID);
        myAddressViewAll=(TextView)view.findViewById(R.id.fragmentMyAccount_myAddressViewMoreID);
        ////
        notification=(TextView)view.findViewById(R.id.fragmentMyAccount_notificationID);
        accountSettings=(TextView)view.findViewById(R.id.fragmentMyAccount_AccountSettingsID);
        logout=(TextView)view.findViewById(R.id.fragmentMyAccount_logoutID);
        /////
        settingPen=(ImageView)view.findViewById(R.id.fragmentMyAccount_settingID);
        /////////////////////////////////////////////////////////////////////////////////////////
        myOrderViewAllOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOrders myOrders=new MyOrders();
                FragmentTransaction transaction=getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_main,myOrders);
                transaction.addToBackStack(myOrders.getTag());
                transaction.commit();
            }
        });
        myAddressViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment=new MyAddressesFrag();
                FragmentTransaction transaction=getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_main,fragment,"MYADDRESSFRAG");
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        myReviewsViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment=new MyReviewsPager();
                FragmentTransaction transaction=getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_main,fragment,"MYREVIEWFRAG");
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        settingPen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment=new PersonalDetailsEdit();
                FragmentTransaction transaction=getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_main,fragment,"PERSONALDETAILEDIT");
                transaction.addToBackStack(fragment.getTag());
                transaction.commit();
            }
        });

        return view ;
    }

}
