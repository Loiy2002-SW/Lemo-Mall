package com.loiy.lemomall.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.textfield.TextInputEditText;
import com.loiy.lemomall.R;
import com.loiy.lemomall.data.UserData;


public class ForgetPasswordDialog extends AppCompatDialogFragment implements UserData {

    //declaration
    EditText editTextUsername;
    Button btnSend;
    int index = -1;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        //instance from AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.forget_password_dialog, null);

        //initialization
        editTextUsername = view.findViewById(R.id.forget_email_edittext);
        btnSend = view.findViewById(R.id.forget_send_button);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEmailIsExist();
            }
        });



        builder.setView(view);

        return builder.create();
    }

    //check Email is found or not
    private void checkEmailIsExist()
    {
        String email = editTextUsername.getText().toString();

        boolean isCorrect = false;
        for (int i = 0; i < emails_arrayList.size(); i++) {

            if(emails_arrayList.get(i).equals(email))
            {
                isCorrect = true;
                index = i;

            }


        }

        if (isCorrect){

            //TODO: here send an email to user for reset password.
            Toast.makeText(getActivity(), getResources().getString(R.string.check_your_email) ,Toast.LENGTH_LONG).show();
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            fragmentManager.beginTransaction().remove(ForgetPasswordDialog.this).commit();
        }else{
            Toast.makeText(getContext(), getResources().getString(R.string.emailNotFound_str) , Toast.LENGTH_LONG).show();
        }


    }//end of checkEmailIsExist()


}