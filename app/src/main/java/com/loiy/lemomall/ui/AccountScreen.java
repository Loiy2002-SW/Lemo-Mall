package com.loiy.lemomall.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.loiy.lemomall.R;
import com.loiy.lemomall.data.CheckInputs;
import com.loiy.lemomall.data.UserData;
import com.loiy.lemomall.modle.BaseMenu;

import java.util.regex.Pattern;

public class AccountScreen extends BaseMenu implements UserData {

    RadioGroup radioGroup;
    EditText editTextFullName, editTextEmail, editTextPhone, editTextPassword;
    TextView tvSave;

    String fullName, email, phone, password;
    int index = -1;

    //an instance of CheckInputs to make validations
    CheckInputs checker = CheckInputs.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_screen);

        //this method will show the more_option icon
        showViews(false, getString(R.string.account_word_str));

        // initialization
        radioGroup = findViewById(R.id.account_radio_group);
        editTextFullName = findViewById(R.id.account_edittext_full_name);
        editTextEmail = findViewById(R.id.account_edittext_email);
        editTextPhone = findViewById(R.id.account_edittext_phone);
        editTextPassword = findViewById(R.id.account_edittext_password);


        tvSave = findViewById(R.id.account_save_textview);




        tvSave.setOnClickListener(this::OnSaveClick);
    }

    private void OnSaveClick(View view) {

        if (!fullNameValidate()
                || !phoneValidate() || !emailValidate() || !validatePassword() || !handleRadioButton()
        )
            return;

        else {
            if (checkEmailIsExists()) {

                fullNames_arrayList.set(index, fullName);
                phoneNumbers_arrayList.set(index, phone);
                emails_arrayList.set(index, email);
                passwords_arrayList.set(index, password);
                setFieldsToEmpty();
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.updateInfoSuccessfully_str), Toast.LENGTH_LONG).show();
            }else{
                editTextEmail.setError(getResources().getString(R.string.emailNotFound_str));

            }

        }
    }

    //check fullName text field
    boolean fullNameValidate()
    {
        fullName = editTextFullName.getText().toString().trim();
        if (fullName.isEmpty()) {
            editTextFullName.setError(getResources().getString(R.string.emptyField_str));
            editTextFullName.setFocusable(true);
            return false;
        }
        else {
            editTextFullName.setError(null);
            return true;
        }
    }//End fullNameValidate()


    //check email text field
    boolean emailValidate()
    {
        email = editTextEmail.getText().toString().trim();
        if (email.isEmpty()) {
            editTextEmail.setError(getResources().getString(R.string.emptyField_str));
            editTextEmail.setFocusable(true);
            return false;
        }else if (!checker.checkEmailFormat(email)) {
            editTextEmail.setError(getResources().getString(R.string.emailFormatErrorMessage_str));
            editTextEmail.setFocusable(true);
            return false;
        }

        else {
            editTextEmail.setError(null);
            return true;
        }
    }//End emailValidate()


    //check phone text field
    boolean phoneValidate()
    {
        phone = editTextPhone.getText().toString().trim();
        if (phone.isEmpty()) {
            editTextPhone.setError(getResources().getString(R.string.emptyField_str));
            editTextPhone.setFocusable(true);
            return false;
        }
        else if (phone.length() != 10)
        {
            editTextPhone.setError(getResources().getString(R.string.phoneLengthErrorMessage_str));
            editTextPhone.setFocusable(true);
            return false;
        }
        else if (!checker.checkPhoneFormat(phone))
        {
            editTextPhone.setError(getResources().getString(R.string.invalidPhone_str));
            editTextPhone.setFocusable(true);
            return false;
        }
        else {
            editTextPhone.setError(null);
            return true;
        }
    }//End phoneValidate()



    private boolean validatePassword() {
        password = editTextPassword.getText().toString().trim();

        final Pattern PASSWORD_PATTERN =
                Pattern.compile("^" +
                        "(?=.*[0-9])" + //at least 1 digit
                        "(?=.*[a-z])" + //at least 1 lower letter
                        "(?=.*[A-Z])" + //at least 1 upper letter
                        "(?=\\S+$)" +  //no white spaces
                        ".{8}" + //at least 8 char
                        "$");

        if (password.isEmpty()) {
            editTextPassword.setError(getResources().getString(R.string.emptyField_str));
            return false;
        }else if (password.length() != 8) {
            editTextPassword.setError(getResources().getString(R.string.passLengthErrorMessage_str));
            return false;
        } else if (!PASSWORD_PATTERN.matcher(password).matches()) {
            editTextPassword.setError(getResources().getString(R.string.passWeak_str));
            return false;
        } else {
            editTextPassword.setError(null);
            return true;
        }
    }


    private boolean handleRadioButton(){

        int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();

        if (selectedRadioButtonId == -1) {
            // No radio button is selected
            Toast.makeText(this, getResources().getString(R.string.choose_payment), Toast.LENGTH_LONG).show();
            return false;
        }
        return true;

    }

    private boolean checkEmailIsExists()
    {

        for (int i = 0; i < emails_arrayList.size(); i++) {

            if(emails_arrayList.get(i).equals(email))
            {
                index = i;
                return true;

            }


        }

        return false;


    }//end of checkEmailIsExists()
    private void setFieldsToEmpty(){
        editTextFullName.setText("");
        editTextPhone.setText("");
        editTextEmail.setText("");
        editTextPassword.setText("");

    }

}