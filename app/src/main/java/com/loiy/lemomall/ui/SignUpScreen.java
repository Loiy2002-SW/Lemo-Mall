package com.loiy.lemomall.ui;

import static com.loiy.lemomall.data.UserData.emails_arrayList;
import static com.loiy.lemomall.data.UserData.fullNames_arrayList;
import static com.loiy.lemomall.data.UserData.passwords_arrayList;
import static com.loiy.lemomall.data.UserData.phoneNumbers_arrayList;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.loiy.lemomall.R;
import com.loiy.lemomall.data.CheckInputs;
import com.loiy.lemomall.sharedPreference.SharedPreferencesManager;

import java.util.regex.Pattern;

public class SignUpScreen extends AppCompatActivity {

    RadioGroup radioGroup;
    EditText editTextFullName, editTextEmail, editTextPhone, editTextPassword;
    ImageView ivSignUp;

    ImageView ivBack_SignUp;
    String fullName, email, phone, password;

    //an instance of CheckInputs to make validations
    CheckInputs checker = CheckInputs.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //remove the title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up_screen);
        // initialization
        radioGroup = findViewById(R.id.sign_up_radio_group);
        editTextFullName = findViewById(R.id.sign_up_edittext_full_name);
        editTextEmail = findViewById(R.id.sign_up_edittext_email);
        editTextPhone = findViewById(R.id.sign_up_edittext_phone);
        editTextPassword = findViewById(R.id.sign_up_edittext_password);


        ivSignUp = findViewById(R.id.sign_up_imageview);
        ivBack_SignUp = findViewById(R.id.sign_up_iv_back);

        ivBack_SignUp.setOnClickListener(this::OnBackToLogin);

        ivSignUp.setOnClickListener(this::OnSignUpImageViewClick);

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

    //go to home activity
    private void goToHomeActivity()
    {
        Intent toHome = new Intent(SignUpScreen.this, HomeScreen.class);
        startActivity(toHome);
        finish();

    }//end of goToHomeActivity()

    private void OnBackToLogin(View view) {

        finish();
    }

    private void OnSignUpImageViewClick(View view) {



        if (!fullNameValidate() || !emailValidate()
                || !phoneValidate() || !validatePassword() || !handleRadioButton()
        )
            return;

        else {
            if (!checkEmailIsExists()) {
                emails_arrayList.add(email);
                fullNames_arrayList.add(fullName);
                phoneNumbers_arrayList.add(phone);
                passwords_arrayList.add(password);
                goToHomeActivity();
                Toast.makeText(SignUpScreen.this, getResources().getString(R.string.welcome_str) + fullName, Toast.LENGTH_LONG).show();
                SharedPreferencesManager.getInstance(this).saveLogin(true);

            }else{
                editTextEmail.setError(getResources().getString(R.string.accountExist_str));
                //Toast.makeText(SignUpScreen.this, getResources().getString(R.string.account_exist), Toast.LENGTH_LONG).show();

            }

        }

    }

    private boolean checkEmailIsExists()
    {

        for (int i = 0; i < emails_arrayList.size(); i++) {

            if(emails_arrayList.get(i).equals(email))
            {
                return true;

            }


        }

        return false;


    }//end of checkEmailIsExists()


}