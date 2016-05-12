package com.example.skilledanswers_d1.overflowmenu.Fragments;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.content.CursorLoader;
import android.support.v7.app.AlertDialog;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.skilledanswers_d1.overflowmenu.R;

import java.io.ByteArrayOutputStream;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created by SkilledAnswers-D1 on 11-05-2016.
 */
public class PersonalDetailsEdit extends Fragment {
    private ImageView profilePICImageview = null;
    private ImageView changeProfilePic = null;
    ///

    ////
    private TextInputEditText firstnameInputEdittext = null;
    private TextInputEditText lastnameInputEdittext = null;
    private TextInputEditText dobInputEdittext = null;
    ////
    private Button save = null;
    private Button cancle = null;
    ///
    private TextInputEditText mobilenotext = null;
    private TextInputEditText emailtext = null;
    ////
    private TextView changepwdtext = null;
    private TextView deactivatetext = null;
    /////// image stuff
    int REQUEST_CAMERA = 0, SELECT_FILE = 1;
    private boolean imageadded = false;
    Bitmap galaryImage = null;
    Bitmap camaraImage = null;
    String encodedImage;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.personal_details_edit, container, false);
        profilePICImageview = (ImageView) view.findViewById(R.id.personal_edit_profilepic);
        changeProfilePic = (ImageView) view.findViewById(R.id.personal_edit_changepic);
        //

        //
        firstnameInputEdittext = (TextInputEditText) view.findViewById(R.id.personal_edit_firstname);
        lastnameInputEdittext = (TextInputEditText) view.findViewById(R.id.personal_edit_lastname);
        dobInputEdittext = (TextInputEditText) view.findViewById(R.id.personal_edit_dob);
        dobInputEdittext.setKeyListener(null);
        //
        save = (Button) view.findViewById(R.id.personal_edit_save);
        cancle = (Button) view.findViewById(R.id.personal_edit_cancle);
        //
        mobilenotext = (TextInputEditText) view.findViewById(R.id.personal_edit_phno);
        mobilenotext.setKeyListener(null);
        emailtext = (TextInputEditText) view.findViewById(R.id.personal_edit_email);
        mobilenotext.setKeyListener(null);
        //
        changepwdtext = (TextView) view.findViewById(R.id.personal_edit_changepwd);
        deactivatetext = (TextView) view.findViewById(R.id.personal_edit_deactivate);
        //
        changeProfilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImage();

            }
        });
        dobInputEdittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showTruitonDatePickerDialog(v);
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStackImmediate();


            }
        });
        return view;
    }


    private void selectImage() {
        final CharSequence[] items = {"Take Photo", "Choose from Library", "Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Add Photo!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (items[item].equals("Take Photo")) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, REQUEST_CAMERA);
                } else if (items[item].equals("Choose from Library")) {
                    Intent intent = new Intent(
                            Intent.ACTION_PICK,
                            android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    intent.setType("image/*");
                    startActivityForResult(
                            Intent.createChooser(intent, "Select File"),
                            SELECT_FILE);
                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == getActivity().RESULT_OK) {
            if (requestCode == REQUEST_CAMERA) {

                camaraImage = (Bitmap) data.getExtras().get("data");
                imageadded = camaraImage != null;
                profilePICImageview.setImageBitmap(camaraImage);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                camaraImage.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                encodedImage = Base64.encodeToString(byteArray, Base64.DEFAULT);

            } else if (requestCode == SELECT_FILE) {
                Uri selectedImageUri = data.getData();
                String[] projection = {MediaStore.MediaColumns.DATA};
                CursorLoader cursorLoader = new CursorLoader(getActivity(), selectedImageUri, projection, null, null,
                        null);
                Cursor cursor = cursorLoader.loadInBackground();
                int column_index = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
                cursor.moveToFirst();

                String selectedImagePath = cursor.getString(column_index);


                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(selectedImagePath, options);
                final int REQUIRED_SIZE = 200;
                int scale = 1;
                while (options.outWidth / scale / 2 >= REQUIRED_SIZE
                        && options.outHeight / scale / 2 >= REQUIRED_SIZE)
                    scale *= 2;
                options.inSampleSize = scale;
                options.inJustDecodeBounds = false;
                galaryImage = BitmapFactory.decodeFile(selectedImagePath, options);
                imageadded = galaryImage != null;
                profilePICImageview.setImageBitmap(galaryImage);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                galaryImage.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                encodedImage = Base64.encodeToString(byteArray, Base64.DEFAULT);


            }
        }

    }

    public class DatePickerFragment extends DialogFragment implements
            DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            dobInputEdittext.setText(day + "/" + (month + 1) + "/" + year);
        }
    }

    public void showTruitonDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getActivity().getSupportFragmentManager(), "datePicker");
    }
}