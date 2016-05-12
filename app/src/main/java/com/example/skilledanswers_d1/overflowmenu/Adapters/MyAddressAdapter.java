package com.example.skilledanswers_d1.overflowmenu.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.skilledanswers_d1.overflowmenu.Fragments.MyAddressEdit;
import com.example.skilledanswers_d1.overflowmenu.MainActivity;
import com.example.skilledanswers_d1.overflowmenu.Model.MyAddressModel;
import com.example.skilledanswers_d1.overflowmenu.R;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by SkilledAnswers-D1 on 10-05-2016.
 */
public class MyAddressAdapter extends RecyclerView.Adapter<MyAddressAdapter.Holder> {

    private ArrayList<MyAddressModel> myAddressModels=null;
    private Context context=null;
    private Fragment fragment=null;
    public static int passPositionToEdit=0;

    public MyAddressAdapter(ArrayList<MyAddressModel> myAddressModels, Context context) {
        this.myAddressModels = myAddressModels;
        this.context = context;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R
        .layout.my_address_row,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(final Holder holder, final int position) {
        MyAddressModel model=myAddressModels.get(position);
        holder.nameTextview.setText(""+model.get_name());
        holder.address.setText(""+model.get_address());
        holder.phno.setText(""+model.get_phno());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu=new PopupMenu(context,holder.imageView);
                popupMenu.getMenuInflater().inflate(R.menu.address_popup,popupMenu.getMenu());
////////////////////////////////
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        int id=item.getItemId();
                        if(id==R.id.editAddressID)
                        {

                            fragment=new MyAddressEdit();
                            FragmentTransaction transaction=((MainActivity)context).getSupportFragmentManager().beginTransaction();
                            transaction.addToBackStack(null);
                            transaction.replace(R.id.content_main,fragment,"MYADDRESSEDIT");
                            transaction.commit();
                            passPositionToEdit=position;   /// passing to position to editfrag.. from there to MyAddress to update the arraylisr;
                        }
                        else if(id==R.id.removeAddressID)
                        {
                            myAddressModels.remove(position);
                            notifyDataSetChanged();
                           Fragment someFragment = ((MainActivity)context).getSupportFragmentManager().findFragmentByTag("MYADDRESSFRAG");
                            View  view=someFragment.getView();
                            TextView t = (TextView) view.findViewById(R.id.fragment_address_savedAddressTextviewID);
                            t.setText(myAddressModels.size()+" Saved Addresses");
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return myAddressModels.size();
    }

    protected class Holder extends RecyclerView.ViewHolder
    {
        protected TextView nameTextview=null;
        protected ImageView imageView=null;
        protected  TextView address=null;
        protected  TextView phno=null;

        public Holder(final View itemView) {
            super(itemView);
            this.nameTextview=(TextView)itemView.findViewById(R.id.myAddress_row_NameID);
            this.imageView=(ImageView)itemView.findViewById(R.id.myAddress_row_OverfloeMenuID);
            this.address=(TextView)itemView.findViewById(R.id.myAddress_row_AddressID);
            this.phno=(TextView)itemView.findViewById(R.id.myAddress_row_PhNoID);

        }
    }

}
