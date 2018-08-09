package com.example.shivam.shivamsood_comp304_assignment4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RLogin extends AppCompatActivity {

    private EditText RepUsername;
    private EditText RepPassword;

    ShoppingManager shoppingManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rlogin);

        shoppingManager = new ShoppingManager(getApplicationContext());

        RepUsername = findViewById(R.id.rLoginUsername);
        RepPassword = findViewById(R.id.rLoginPassword);



    }

    public void gotoRepresentativeMenu(View view) {

        //If the customer succesfully log in
        // add an if statement that user succefully log in
        String input_username = RepUsername.getText().toString();
        String input_password = RepPassword.getText().toString();
        Order_obj repa = new Order_obj();


        try {

            repa = shoppingManager.getorderById(input_username, "userName");



            if (input_username.equals(repa.getUserName()) && input_password.equals(repa.getPassword())) {

                SharedPreferences myPreference =
                        getSharedPreferences("RepaMemory", 0);
                //prepare it for edit by creating and Edit object
                SharedPreferences.Editor prefEditor = myPreference.edit();
                //store a string in memory
                prefEditor.putString("RepresentativeUsername", RepUsername.getText().toString());
                //commit the transaction
                prefEditor.commit();
                //call intent only to show the next activity
                Intent intent = new Intent(this, RepresentativeMenu.class);
                startActivity(intent);

            } else {

                Toast.makeText(RLogin.this,
                        "Username and password did not match" + input_password + " did not match", Toast.LENGTH_SHORT).show();
            }


        } catch (Exception e) {
            Toast.makeText(RLogin.this,
                    "Representive does not exist, Please try to Register First", Toast.LENGTH_SHORT).show();

            Log.i("Error: ", e.getMessage());

        }


    }
}
