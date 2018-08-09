package com.example.shivam.shivamsood_comp304_assignment4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CRegister extends AppCompatActivity {
    private EditText fName, lName, address, postalCode, userName, password;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cregister);
        setTitle("Customer Registration");



        fName = (EditText) findViewById(R.id.fName);
        lName = (EditText) findViewById(R.id.lName);
        address = (EditText) findViewById(R.id.address);
        postalCode = (EditText) findViewById(R.id.postalCode);
        userName = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.password);
        btnAdd = (Button) findViewById(R.id.btnCustomerRegistration);
    }
    public void addCustomer(View view)
    {
        String fnameLocal = fName.getText().toString();
        String lNameLocal = lName.getText().toString();
        String addressLocal = address.getText().toString();
        String postalCodeLocal = postalCode.getText().toString();
        String userNameLocal = userName.getText().toString();
        String passwordLocal = password.getText().toString();

        try {
            MainActivity.addCustomer(fnameLocal, lNameLocal, addressLocal, postalCodeLocal, userNameLocal, passwordLocal);

            Toast.makeText(CRegister.this,
                    fnameLocal +" has been added as Customer", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(CRegister.this,
                    e.getMessage(), Toast.LENGTH_SHORT).show();

        }
        Intent intent = new Intent(this, Customer.class);
        startActivity(intent);



    }
    @Override
    protected void onRestart() {

        // TODO Auto-generated method stub
        super.onRestart();
        Intent i = new Intent(this, RRegister.class);  //your class
        startActivity(i);
        finish();

    }

}

