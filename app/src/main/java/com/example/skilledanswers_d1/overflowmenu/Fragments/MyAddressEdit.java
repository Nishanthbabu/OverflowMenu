package com.example.skilledanswers_d1.overflowmenu.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;

import com.example.skilledanswers_d1.overflowmenu.Adapters.MyAddressAdapter;
import com.example.skilledanswers_d1.overflowmenu.R;

/**
 * Created by SkilledAnswers-D1 on 10-05-2016.
 */
public class MyAddressEdit extends Fragment {

    private TextInputLayout nameLayout=null;
    private TextInputLayout pincodeLayout=null;
    private TextInputLayout addressLayout=null;
    private TextInputLayout landmarkLayout=null;
    private TextInputLayout cityLayout=null;
    private TextInputLayout stateLayout=null;
    private TextInputLayout phNoLayout=null;
    /////
    private Button save=null;
    private Button cancle=null;
    /////
    private TextInputEditText nameEdit=null;
    private TextInputEditText pinEdit=null;
    private TextInputEditText addressEdit=null;
    private TextInputEditText landMarkEdit=null;
    private TextInputEditText cityEdit=null;
    private TextInputEditText stateEdit=null;
    private TextInputEditText phNoEdit=null;
    private Fragment fragment=null;
    /////

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View  view=inflater.inflate(R.layout.edit_address,container,false);



        nameLayout=(TextInputLayout)view.findViewById(R.id.myAddressNameLayout);
        pincodeLayout=(TextInputLayout)view.findViewById(R.id.myAddresspinLayout);
        addressLayout=(TextInputLayout)view.findViewById(R.id.myAddressAddressLayout);
        landmarkLayout=(TextInputLayout)view.findViewById(R.id.myAddressLandmarkLayout);
        cityLayout=(TextInputLayout)view.findViewById(R.id.myAddressCityLayout);
        stateLayout=(TextInputLayout)view.findViewById(R.id.myAddressStateLayout);
        phNoLayout=(TextInputLayout)view.findViewById(R.id.myAddressPhnoLayout);
        //////
        save=(Button)view.findViewById(R.id.myAddressSaveButton);
        cancle=(Button)view.findViewById(R.id.myAddressCancleButton);
        //////
        nameEdit=(TextInputEditText)view.findViewById(R.id.myAddressNameId);
        pinEdit=(TextInputEditText)view.findViewById(R.id.myAddressPinCodeId);
        addressEdit=(TextInputEditText)view.findViewById(R.id.myAddressAddressId);
        landMarkEdit=(TextInputEditText)view.findViewById(R.id.myAddressLandmark);
        cityEdit=(TextInputEditText)view.findViewById(R.id.myAddressCity);
        stateEdit=(TextInputEditText)view.findViewById(R.id.myAddressState);
        phNoEdit=(TextInputEditText)view.findViewById(R.id.myAddressPhno);
        //////////////////////////////////////////////////////////////////////////////////////
        // textwatchewr
        nameEdit.addTextChangedListener(new TextwatcherAddress(nameEdit));
        pinEdit.addTextChangedListener(new TextwatcherAddress(pinEdit));
        addressEdit.addTextChangedListener(new TextwatcherAddress(addressEdit));
        cityEdit.addTextChangedListener(new TextwatcherAddress(cityEdit));
        stateEdit.addTextChangedListener(new TextwatcherAddress(stateEdit));
        phNoEdit.addTextChangedListener(new TextwatcherAddress(phNoEdit));
        /////////////

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle=getArguments();
                if(bundle!=null) {
                    if(bundle.getString("ADDRESS_ACTION").equals("add_address"))
                    {
                        submitForm();
                    }
                }else {
                    submitEditedForm();
                }

            }
        });
        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyAddressesFrag.editName=null;
                MyAddressesFrag.editPhno=null;
                MyAddressesFrag.editAddress=null;
                MyAddressesFrag.editablePosition= 0;
                MyAddressesFrag.updateAddress=false;
                getActivity().getSupportFragmentManager().popBackStackImmediate();

            }
        });


        ///////
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();


    }

    ///// validate name
    private boolean validateName()
    {
        if(nameEdit.getText().toString().trim().isEmpty())
        {
            nameLayout.setError("name field is empty..");
            return false;
        }else
        {
            nameLayout.setErrorEnabled(false);
            return true;
        }
    }
    ///// validate pincode
    private boolean validatePinCode()
    {
         if(pinEdit.getText().toString().trim().isEmpty())
        {
            pincodeLayout.setError("pin code field is empty..");
            return false;
        }
        else
        {
            pincodeLayout.setErrorEnabled(false);
            return true;
        }
    }
    ///// validate address
    private boolean validateAddress()
    {
        if (addressEdit.getText().toString().trim().isEmpty())
        {
            addressLayout.setError("address field is empty..");
            return false;
        }else
        {
            addressLayout.setErrorEnabled(false);
            return true;
        }
    }

    ///// validate city
    private boolean validateCity()
    {
        if (cityEdit.getText().toString().trim().isEmpty())
        {
            cityLayout.setError("city field is empty..");
            return false;
        }else
        {
            cityLayout.setErrorEnabled(false);
            return true;
        }
    }

    ///// validate state
    private boolean validateState()
    {
        if (stateEdit.getText().toString().trim().isEmpty())
        {
            stateLayout.setError("state field is empty..");
            return false;
        }else
        {
            stateLayout.setErrorEnabled(false);
            return true;
        }
    }
    ////// validate phno
    private boolean validatePhno(String number)
    {
        if(!android.util.Patterns.PHONE.matcher(number).matches())
        {
            phNoLayout.setError("invalid phone no..");
            return false;

        }
        else if(number.isEmpty())
        {
            phNoLayout.setError("phno field is empty");
            return false;

        }
        else
        {
            phNoLayout.setErrorEnabled(false);
            return true;
        }
    }
    ///////// req focus...
    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_IS_FORWARD_NAVIGATION);
        }
    }
    ///////// validating the edited form....
    private void submitEditedForm()
    {
        if(!validateName())
        {
            return;
        }
        if(!validatePinCode())
        {
            return;
        }
        if(!validateAddress())
        {
            return;
        }
        if(!validateCity())
        {
            return;
        }
        if(!validateState())
        {
            return;
        }
        if(!validatePhno(phNoEdit.getText().toString().trim()))
        {
            return;
        }
        MyAddressesFrag.editName=nameEdit.getText().toString();
        MyAddressesFrag.editPhno=phNoEdit.getText().toString();
        MyAddressesFrag.editAddress=addressEdit.getText().toString();
        MyAddressesFrag.editablePosition= MyAddressAdapter.passPositionToEdit;  //// passint the position
        MyAddressesFrag.updateAddress=true;        ///// not updating the address...
        getActivity().getSupportFragmentManager().popBackStackImmediate();



    }

    ///////// validating the form....
    private void submitForm()
    {
        if(!validateName())
        {
            return;
        }
        if(!validatePinCode())
        {
            return;
        }
        if(!validateAddress())
        {
            return;
        }
        if(!validateCity())
        {
            return;
        }
        if(!validateState())
        {
            return;
        }
        if(!validatePhno(phNoEdit.getText().toString().trim()))
        {
            return;
        }
//        public static String addName=null;
//        public static String  addPincode=null;
//        public static String addAddress=null;
//        public static String addLandmark=null;
//        public static String addCity=null;
//        public static String addState=null;
//        public static String addPhno=null;
        MyAddressesFrag.addName=nameEdit.getText().toString();
        MyAddressesFrag.addPincode=pinEdit.getText().toString();
        MyAddressesFrag.addAddress=addressEdit.getText().toString();
        MyAddressesFrag.addLandmark=landMarkEdit.getText().toString();
        MyAddressesFrag.addCity=cityEdit.getText().toString();
        MyAddressesFrag.addState=stateEdit.getText().toString();
        MyAddressesFrag.addPhno=phNoEdit.getText().toString();
        MyAddressesFrag.addAditionalAddress=true;
        getActivity().getSupportFragmentManager().popBackStackImmediate();

    }
    ///////
    private class TextwatcherAddress implements TextWatcher
    {
        private View view;
        private TextwatcherAddress(View view)
        {
            this.view=view;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            switch (view.getId())
            {
                case R.id.myAddressNameId: validateName();
                    break;
                case R.id.myAddressPinCodeId: validatePinCode();
                    break;
                case R.id.myAddressAddressId: validateAddress();
                    break;
                case R.id.myAddressCity: validateCity();
                    break;
                case R.id.myAddressState: validateState();
                    break;
                case R.id.myAddressPhno:   validatePhno(phNoEdit.getText().toString().trim());
                    break;
            }
        }
    }
}
