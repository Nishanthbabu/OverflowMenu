package com.example.skilledanswers_d1.overflowmenu.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.skilledanswers_d1.overflowmenu.Adapters.MyOrdersAdapter;
import com.example.skilledanswers_d1.overflowmenu.MainActivity;
import com.example.skilledanswers_d1.overflowmenu.Model.MyOrderModel;
import com.example.skilledanswers_d1.overflowmenu.R;
import com.example.skilledanswers_d1.overflowmenu.RecyclerItemClickListener;

import java.util.ArrayList;

/**
 * Created by SkilledAnswers-D1 on 07-05-2016.
 */
public class MyOrders extends Fragment {
    private RecyclerView recyclerView=null;
    private RecyclerView.LayoutManager layoutManager=null;
    //////// dummy data
    private String[] orderedDate={"wed, Fed 10, 2016","sun, jan 10, 2016","sat, dec 10, 2015","sun, nov 10, 2015","mon, nov 5, 2015"};
    private String[] orderID={"01344000","4436540150","0548941553","56411566","548472158"};
    private int[] productImage={R.drawable.camara,R.drawable.frame,R.drawable.camara,R.drawable.lens,R.drawable.lenscleaner};
    private String[] productName={"HD camara","Photo frame light","Wall painting","Camera Lens","Camera Lens Cleaner"};
    private boolean[] delevered={true,true,true,false,false};
    private boolean[] ontheway={false,false,false,true,false};
    private boolean[] cancled={false,false,false,false,true};
    private String[] shipmentDetails={"delivered on 15,fed 2016","delivered on 16,jan 2016","delivered on 20,dec 2015",
                                        "yet to delever by 20,nov 2015","Cancled on 10,nov 2015"};
//{"delivered on 15,fed 2016","delivered on 16,jan 2016","delivered on 20,dec 2015",
//    "yet to delever by 20,nov 2015","Cancled on 10,nov 2015"};
    private ArrayList<MyOrderModel> getdata()
    {
        ArrayList<MyOrderModel> myOrderModels=new ArrayList<>();
        for(int i=0;i<orderedDate.length;i++)
        {
            MyOrderModel model=new MyOrderModel();
            model.set_orderDate(orderedDate[i]);
            model.set_orderId(orderID[i]);
            model.set_productImage(productImage[i]);
            model.set_productName(productName[i]);
            model.set_delevered(delevered[i]);
            model.set_ontheway(ontheway[i]);
            model.set_cancled(cancled[i]);
            model.set_productDeleveryDesc(shipmentDetails[i]);
            myOrderModels.add(model);
        }
        return myOrderModels;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.recycleview_fragment,container,false);
        recyclerView=(RecyclerView)view.findViewById(R.id.recycleviewFragmentID);
        layoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        MyOrdersAdapter adapter=new MyOrdersAdapter(getActivity(),getdata());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        Toolbar toolbar = (Toolbar)getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("My Orders");
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                OrderDetails orderDetails=new OrderDetails();
                FragmentTransaction transaction=getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_main,orderDetails);
                transaction.addToBackStack(orderDetails.getTag());
                transaction.commit();
            }
        }));
        return  view;
    }
}
