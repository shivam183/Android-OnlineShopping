package com.example.shivam.shivamsood_comp304_assignment4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Representative extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_representative);

    }

    public void Rlogin (View view ){
        // Do something in response to button

        Intent intent = new Intent(this, RLogin.class);
        //switch scenes
        startActivity(intent);

    }

    public void Rregister (View view ){
        // Do something in response to button

        Intent intent = new Intent(this, RRegister.class);
        //switch scenes
        startActivity(intent);

    }
}
