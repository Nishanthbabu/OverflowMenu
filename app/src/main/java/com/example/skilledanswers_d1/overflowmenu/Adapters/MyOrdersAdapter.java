package com.example.skilledanswers_d1.overflowmenu.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.skilledanswers_d1.overflowmenu.Model.MyOrderModel;
import com.example.skilledanswers_d1.overflowmenu.R;

import java.util.ArrayList;

/**
 * Created by SkilledAnswers-D1 on 09-05-2016.
 */
public class MyOrdersAdapter extends RecyclerView.Adapter<MyOrdersAdapter.Holder> {
    private Context context=null;
    private ArrayList<MyOrderModel> myOrderModels=null;

    public MyOrdersAdapter(Context context, ArrayList<MyOrderModel> myOrderModels) {
        this.context = context;
        this.myOrderModels = myOrderModels;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
      View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.my_orders_row,null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        MyOrderModel model=myOrderModels.get(position);
        holder.orderedDate.setText(""+model.get_orderDate());
        holder.orderID.setText(""+model.get_orderId());
        holder.productImage.setImageResource(model.get_productImage());
        holder.productName.setText(""+model.get_productName());
        if(model.is_delevered())
        {
            holder.status.setText("Delevered");
        }
        else if(model.is_ontheway())
        {
            holder.status.setText("On the way");
        }
        else if(model.is_cancled()) {
            holder.status.setText("Cancled");
            holder.cardView.setAlpha(0.10f);    /// default alpha is 255
        }
       holder.statusdesc.setText(""+model.get_productDeleveryDesc());
    }

    @Override
    public int getItemCount() {
        return myOrderModels.size();
    }

    protected class Holder extends RecyclerView.ViewHolder
    {
        protected TextView orderedDate=null;
        protected TextView orderID=null;
        protected ImageView productImage=null;
        protected TextView productName=null;
        protected TextView status=null;
        protected TextView statusdesc=null;
        protected CardView cardView =null;

        public Holder(View itemView) {
            super(itemView);

            this.orderedDate=(TextView)itemView.findViewById(R.id.my_orderRow_OrderDateID);
            this.orderID=(TextView)itemView.findViewById(R.id.my_orderRow_OrderIdID);
            this.productImage=(ImageView)itemView.findViewById(R.id.my_orderRow_imageviewID);
            this.productName=(TextView)itemView.findViewById(R.id.my_orderRow_productNameID);
            this.status=(TextView)itemView.findViewById(R.id.my_orderRow_deleverystatusID);
            this.statusdesc=(TextView)itemView.findViewById(R.id.my_orderRow_deleverydescID);
            this.cardView =(CardView)itemView.findViewById(R.id.my_orderRow_Cardview);
        }
    }
}
