package com.example.shivam.shivamsood_comp304_assignment4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class  CLogin extends AppCompatActivity {

    private EditText customerUsername;
    private EditText customerPassword;

    ShoppingManager shoppingManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clogin);
        setTitle("");

        shoppingManager = new ShoppingManager(getApplicationContext());

        customerUsername = findViewById(R.id.cLoginUsername);
        customerPassword = findViewById(R.id.cLoginPassword);


    }

    public void gotoCustomerMenu(View view) {

        //If the customer succesfully log in
        // add an if statement that user succefully log in
        String input_username = customerUsername.getText().toString();
        String input_password = customerPassword.getText().toString();
        Customer_obj customer = new Customer_obj();


        try {

            customer = shoppingManager.getCustomerById(input_username, "userName");

            if (input_username.equals(customer.getUserName()) && input_password.equals(customer.getPassword())) {

                SharedPreferences myPreference =
                        getSharedPreferences("CustomerMemory", 0);
                //prepare it for edit by creating and Edit object
                SharedPreferences.Editor prefEditor = myPreference.edit();
                //store a string in memory
                prefEditor.putString("CustomerUsername", customerUsername.getText().toString());
                //commit the transaction
                prefEditor.commit();
                //call intent only to show the next activity
                Intent intent = new Intent(this, CustomerMenu.class);
                startActivity(intent);

            } else {

                Toast.makeText(CLogin.this,
                        "Username and password did not match" + input_password + " did not match", Toast.LENGTH_SHORT).show();
            }


        } catch (Exception e) {
            Toast.makeText(CLogin.this,
                    "Customer does not exist, Please try to Register First", Toast.LENGTH_SHORT).show();

            Log.i("Error: ", e.getMessage());

        }


    }
}
