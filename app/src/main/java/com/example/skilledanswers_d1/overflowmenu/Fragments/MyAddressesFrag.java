package com.example.skilledanswers_d1.overflowmenu.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.skilledanswers_d1.overflowmenu.Adapters.MyAddressAdapter;
import com.example.skilledanswers_d1.overflowmenu.Model.MyAddressModel;
import com.example.skilledanswers_d1.overflowmenu.R;

import java.util.ArrayList;

/**
 * Created by SkilledAnswers-D1 on 09-05-2016.
 */
public class MyAddressesFrag extends Fragment {
    ////////////////////
    public static boolean updateAddress=false; ////// passed from chilf fragment when it gets some data to update
    public static String  editName=null;
    public static String editPhno=null;     ////// static data to get the  data
    public static String editAddress=null;
    public static int editablePosition=0;
    ///////////////////
    private RecyclerView recyclerView=null;
    private TextView addaddressTextview=null;
    private TextView noOfAddressTextview=null;
    ////////
    private RecyclerView.LayoutManager layoutManager=null;
//////////////////////////////////// dummy
    private String name="Nishanth";
    private String phno="9741987196";
    private String[] addresss={"United States: \n" +
            "SkilledAnswers, Inc. \n" +
            "4512 Legacy Drive, #100, Plano, Texas 75024 \n" +
            "Phone: 972-961-4814 \n" +
            "(State of Delaware, U.S. File Number: 5640983)",
    "India: Registered Company Postal Address \n" +
            "SkilledAnswers InfoSolutions Pvt Ltd. \n" +
            "#6, 1st Main Road , N.S Palya, BTM Layout, Bangalore - 560076, Karnataka, India",
    "India: IT Development & Deployment Center \n" +
            "SkilledAnswers InfoSolutions Pvt Ltd. \n" +
            "#1417, 4th Main, 20th Cross, 7th Sector, HSR Layout, Bangalore - 560102, Karnataka, India"};
  static   ArrayList<MyAddressModel> myAddressModels=new ArrayList<>();
    private void setdata()
    {

        for(int i=0;i<addresss.length;i++)
        {
            MyAddressModel model=new MyAddressModel();
            model.set_name(name);
            model.set_phno(phno);
            model.set_address(addresss[i]);
            myAddressModels.add(model);
        }

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_my_addresses,container,false);

        recyclerView=(RecyclerView)view.findViewById(R.id.fragment_my_address_recycleviewID);
        addaddressTextview=(TextView)view.findViewById(R.id.fragment_addAddressTextviewID);
        noOfAddressTextview=(TextView)view.findViewById(R.id.fragment_address_savedAddressTextviewID);
        layoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        myAddressModels.clear();
        setdata();
        noOfAddressTextview.setText(myAddressModels.size()+" Saved Addresses");
        MyAddressAdapter adapter=new MyAddressAdapter(myAddressModels,getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        ////////////////
        addaddressTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if(updateAddress)
        {
            Toast.makeText(getActivity(),"here",Toast.LENGTH_LONG).show();
            myAddressModels.get(editablePosition).set_address(editAddress);
            myAddressModels.get(editablePosition).set_name(editName);
            myAddressModels.get(editablePosition).set_phno(editPhno);
            layoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
            MyAddressAdapter adapter=new MyAddressAdapter(myAddressModels,getActivity());
            recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
            updateAddress=false;

        }
    }
}
