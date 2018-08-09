package com.example.shivam.shivamsood_comp304_assignment4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CustomerMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_menu);

        SharedPreferences myPref = getSharedPreferences("CustomerMemory", MODE_PRIVATE);
        String myString = myPref.getString("CustomerUsername","");
        TextView tView = (TextView)findViewById(R.id.txtCusUserName);
        tView.setText("Customer Username: "+myString);
    }
    public void gotoShoppingScreen(View view){

        //If the customer succesfully log in
        // add an if statement that user succefully log in
        //call intent only to show the next activity
        Intent intent = new Intent(this, ShoppingScreen.class);
        startActivity(intent);



    }
    public void gotoOrderInfoScreen(View view){

        //If the customer succesfully log in
        // add an if statement that user succefully log in
        //call intent only to show the next activity
        Intent intent = new Intent(this, OrderInformation.class);
        startActivity(intent);



    }
    public void SignOut(View view){

        //If the customer succesfully log in
        // add an if statement that user succefully log in
        //call intent only to show the next activity
        Intent intent = new Intent(this, Customer.class);
        startActivity(intent);



    }
}

