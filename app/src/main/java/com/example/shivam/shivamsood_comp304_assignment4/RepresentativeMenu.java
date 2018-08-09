package com.example.shivam.shivamsood_comp304_assignment4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RepresentativeMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_representative_menu);
    }

    public void gotoViewCustomerOrder(View view){

        //If the customer succesfully log in
        // add an if statement that user succefully log in
        //call intent only to show the next activity
        Intent intent = new Intent(this, ViewDetails.class);
        startActivity(intent);



    }
    public void gotoChangeOrderStatus(View view){

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
        Intent intent = new Intent(this, Representative.class);
        startActivity(intent);



    }
}
