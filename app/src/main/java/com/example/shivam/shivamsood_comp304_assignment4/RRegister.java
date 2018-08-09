package com.example.shivam.shivamsood_comp304_assignment4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RRegister extends AppCompatActivity {

    private ShoppingManager shoppingManager;
    private EditText fName, lName, userName, password;
    private Button btnAdd;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rregister);
        setTitle("Representative Registeration");

        shoppingManager = new ShoppingManager(getApplicationContext());

        fName = (EditText) findViewById(R.id.rRegFName);
        lName = (EditText) findViewById(R.id.rRegLName);
        userName = (EditText) findViewById(R.id.rRegUsername);
        password = (EditText) findViewById(R.id.rRegPassword);
        btnAdd = (Button) findViewById(R.id.representative_btn);

    }

    public void addRepresenative(View view)
    {
        String fnameLocal = fName.getText().toString();
        String lNameLocal = lName.getText().toString();
        String userNameLocal = userName.getText().toString();
        String passwordLocal = password.getText().toString();

        try {
            MainActivity.addOrderRep(fnameLocal, lNameLocal,userNameLocal, passwordLocal);
            Toast.makeText(RRegister.this,
                    fnameLocal +" has been added as a Representative", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, Representative.class);
            startActivity(intent);

        }catch (Exception e){
            Toast.makeText(RRegister.this,
                    e.getMessage(), Toast.LENGTH_SHORT).show();

        }


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
