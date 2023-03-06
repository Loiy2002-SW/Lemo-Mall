package com.loiy.lemomall.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.DialogFragment;

import com.loiy.lemomall.R;



public class MenuDialog extends AppCompatDialogFragment {

    // fields declaration.
    TextView menu_dialog_account_textview, menu_dialog_basket_textview, menu_dialog_orders_textview, menu_dialog_logout_textview;


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        // build the dialog and linked it with the menu_dialog.xml layout.
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.menu_dialog, null);


        // initialization.
        menu_dialog_account_textview = view.findViewById(R.id.menu_dialog_account_textview);
        menu_dialog_basket_textview = view.findViewById(R.id.menu_dialog_basket_textview);
        menu_dialog_orders_textview = view.findViewById(R.id.menu_dialog_orders_textview);
        menu_dialog_logout_textview = view.findViewById(R.id.menu_dialog_logout_textview);


        // set the listeners to one method 'onMenuDialogListener'
        menu_dialog_account_textview.setOnClickListener(this::onMenuDialogListener);
        menu_dialog_basket_textview.setOnClickListener(this::onMenuDialogListener);
        menu_dialog_orders_textview.setOnClickListener(this::onMenuDialogListener);
        menu_dialog_logout_textview.setOnClickListener(this::onMenuDialogListener);

        builder.setView(view);

        return builder.create();
    }

    private void onMenuDialogListener(View view) {

        switch (view.getId()){

            // open account activity when click on account icon.
            case R.id.menu_dialog_account_textview:

                Toast.makeText(getContext(), getString(R.string.account_str), Toast.LENGTH_SHORT).show();

                break;

            // open basket activity when click on basket icon.
            case R.id.menu_dialog_basket_textview:

                Toast.makeText(getContext(), getString(R.string.basket_str), Toast.LENGTH_SHORT).show();

                break;

            // open orders activity when click on orders icon.
            case R.id.menu_dialog_orders_textview:

                Toast.makeText(getContext(), getString(R.string.orders_str), Toast.LENGTH_SHORT).show();

                break;

            // logout and go to the login screen.
            case R.id.menu_dialog_logout_textview:

                Toast.makeText(getContext(), getString(R.string.logout_str), Toast.LENGTH_SHORT).show();

                break;


        }
    }



}