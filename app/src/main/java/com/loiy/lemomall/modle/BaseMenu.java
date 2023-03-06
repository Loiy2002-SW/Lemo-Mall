package com.loiy.lemomall.modle;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.loiy.lemomall.R;
import com.loiy.lemomall.ui.MenuDialog;

public abstract class BaseMenu extends AppCompatActivity {

    // fields declaration
    ImageView menu_dialog_more_option_imageview;
    TextView menu_dialog_back_textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //remove the title bar.
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.base_menu);
/*
       *Important notes:
         - I did not write any code here because this method will be overridden by child classes.
         - so the call of the method will be in the child class.
         - the benefit of this is to write the code of the menu and back button one time and reuse it in the child classes
         - which will increase the performance the minimize the usage of the memory.

*/

    }

    //on menu listener( include the more_option icon and the back icon)
    private void onMenuListener(View view) {

        switch (view.getId()){

            // open menu when click on the more_option.
            case R.id.menu_dialog_more_option_imageview:

                MenuDialog dialog = new MenuDialog();
                dialog.show(getSupportFragmentManager(),"Dialog");

                break;

                //finish this activity when click on back arrow.
            case R.id.menu_dialog_back_textview:

                  finish();

        }

    }

    //when this method is called the more_option icon and the back icon will be shown depend on the arguments.
    public void showViews(boolean isHome, String name){

        //initialization.
        menu_dialog_more_option_imageview = findViewById(R.id.menu_dialog_more_option_imageview);
        menu_dialog_back_textview = findViewById(R.id.menu_dialog_back_textview);


        //set the listeners to one method 'onMenuListener'
        menu_dialog_more_option_imageview.setOnClickListener(this::onMenuListener);
        menu_dialog_back_textview.setOnClickListener(this::onMenuListener);


        // the back_arrow is GONE by default (from XML code), but if the child activity was not the home it should be visible.
        // and the name of that activity should be updated depend on the argument (name).
        if(!isHome) {
            menu_dialog_back_textview.setVisibility(View.VISIBLE);
            menu_dialog_back_textview.setText(name);
        }


    }



}
