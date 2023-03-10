package com.loiy.lemomall.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.loiy.lemomall.R;
import com.loiy.lemomall.data.UserData;
import com.loiy.lemomall.sharedPreference.SharedPreferencesManager;

import java.util.regex.Pattern;

public class LoginScreen extends AppCompatActivity implements UserData {

    //declaration
    EditText editTextEmail, editTextPassword;
    ImageView ivLogin;
    TextView tvSignUp, tvForgetPass;
    int index = -1;
    String email, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //remove the title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login_screen);

        //initialization
        editTextEmail = findViewById(R.id.login_edittext_email);
        editTextPassword = findViewById(R.id.login_edittext_password);
        tvSignUp = findViewById(R.id.login_sign_up_textview);
        tvForgetPass = findViewById(R.id.login_forget_password_textview);
        ivLogin = findViewById(R.id.login_login_imageview);

        //onClick
        ivLogin.setOnClickListener(this::onClickListener);
        tvSignUp.setOnClickListener(this::onClickListener);
        tvForgetPass.setOnClickListener(this::onClickListener);
    }



    //check Email and password (correct or not).
    private void checkEmailPassword()
    {
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();
        boolean isCorrect = false;
        for (int i = 0; i < emails_arrayList.size(); i++) {

            if(emails_arrayList.get(i).equals(email) && passwords_arrayList.get(i).equals(password))
            {
                isCorrect = true;
                index = i;

            }


        }


        if (isCorrect) {

            startActivity(new Intent(LoginScreen.this, HomeScreen.class));

            SharedPreferencesManager.getInstance(this).saveLogin(true);

            Toast.makeText(getApplicationContext(), getResources().getString(R.string.welcome_str) + fullNames_arrayList.get(index) + " (:", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.invalidPass_str), Toast.LENGTH_LONG).show();
        }




    }//end of checkEmailPassword()


    //check email text field
    boolean emailValidate()
    {
        email = editTextEmail.getText().toString().trim();
        if (email.isEmpty()) {
            editTextEmail.setError(getResources().getString(R.string.emptyField_str));
            return false;
        }

        else {
            editTextEmail.setError(null);
            return true;
        }
    }//End emailValidate()

    //password validate
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

    private void onClickListener(View view) {
        switch (view.getId()){
            case R.id.login_login_imageview:

                if (!emailValidate() || !validatePassword()){
                    return;
                }else {
                    checkEmailPassword();
                }

                break;
            case R.id.login_sign_up_textview:

                startActivity(new Intent(LoginScreen.this, SignUpScreen.class));
                break;
            case R.id.login_forget_password_textview:
                openDialog();
        }
    }//end of onClickListener()

    //open ForgetPasswordDialog
    private void openDialog(){
        ForgetPasswordDialog dialog = new ForgetPasswordDialog();
        dialog.show(getSupportFragmentManager(),"Dialog");
    }


}