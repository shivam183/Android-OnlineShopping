package com.example.shivam.shivamsood_comp304_assignment4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class OrderInformation extends AppCompatActivity {

    String myString;
    ShoppingManager shoppingManager;
    private TextView orderinfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_information);
        viewSelectedItems();

        SharedPreferences myPref = getSharedPreferences("CustomerMemory", MODE_PRIVATE);
        myString = myPref.getString("CustomerUsername","");
        TextView tView = (TextView)findViewById(R.id.txtOrderInfoCus);
        tView.setText("Customer Username: "+myString);


        //CALCULATING AMOUNT, AND SHOWING THE NUMBER AMOUNT OF ITEM
        //  orderinfo = findViewById(R.id.txtOrderInformation);
//
        //  SharedPreferences myPref1 = getSharedPreferences("SocksItem", MODE_PRIVATE);
        //  String myString1 = myPref.getString("Addidas_Sock","");
        //  orderinfo.setText("Item ID: 21313 \nItem Name: " + myString1+ "\nDelivery Date: July 12\nPrice: 11.99" );



    }

    public void viewSelectedItems()
    {
        ListView lv = (ListView) findViewById(R.id.beautiful_list);
        lv.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
        Intent intent = getIntent();
        ArrayList<String> stringArray = intent.getStringArrayListExtra("string-array");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, stringArray);
        lv.setAdapter(adapter);

    }
    public void CancelOrder(View view){
        //delete the row with the orderitemID from orderitem table
        SQLiteDatabase db = shoppingManager.getReadableDatabase();
        Cursor c2 = db.rawQuery("select CustomerID from customers WHERE userName = ?", new String[]{myString});

        try {
            if (c2.moveToFirst())
            {
                c2.moveToLast();
                shoppingManager.delete("Order_", "customer_ID", c2.getInt(0));
                c2.close();
                onRestart();

            }


            Toast.makeText(this, "testsuccess", Toast.LENGTH_SHORT).show();
        }
        catch(Exception e){
            Toast.makeText(this, "testfailed", Toast.LENGTH_SHORT).show();}

    }
    public void ChangeDate(View view){

        //update date in ordertable;

    }

    protected void onRestart() {

        // TODO Auto-generated method stub
        super.onRestart();
        Intent i = new Intent(this, OrderInformation.class);  //your class
        startActivity(i);
        finish();

    }
}
