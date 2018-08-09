package com.example.shivam.shivamsood_comp304_assignment4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Customer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        setTitle("Customer Portal");

    }


    public void Clogin (View view ){
        // Do something in response to button

        Intent intent = new Intent(this, CLogin.class);
        //switch scenes
        startActivity(intent);

    }

    public void Cregister (View view ){
        // Do something in response to button

        Intent intent = new Intent(this, CRegister.class);
        //switch scenes
        startActivity(intent);

    }
}

