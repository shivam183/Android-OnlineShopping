package com.example.shivam.shivamsood_comp304_assignment4;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static ShoppingManager shoppingManager;
    private final static String CUSTOMER_TABLE = "Customers ";
    private final static String ORDERREP_TABLE = "OrderRep ";
    private final static String ITEM_TABLE = "Item";
    private final static String ORDER_TABLE = "Order_";
    private static Item_obj itemid;
    private static Customer_obj customerid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        itemid = new Item_obj();
        customerid = new Customer_obj();
        setTitle("HomePage");
        try {
            shoppingManager = new ShoppingManager(getApplicationContext());

            //test Connection
            Toast.makeText(MainActivity.this,
                    "Database Created", Toast.LENGTH_SHORT).show();
        }

        catch(Exception exception)
        {
            Toast.makeText(MainActivity.this,
                    exception.getMessage(), Toast.LENGTH_SHORT).show();
            Log.i("Error: ",exception.getMessage());
        }

    }

    public static void addOrder(Integer itemID, Integer customerID,
                                Integer amount, String DeliveryDate, String status)
    {
        Random orderNum = new Random();
        int randomInt = orderNum.nextInt(900) + 1;
        itemid.setItemID(randomInt);
        ContentValues contentValues = new ContentValues();



        contentValues.put("orderID", randomInt);
        contentValues.put("item_ID", itemID);
        contentValues.put("customer_ID", customerID);
        contentValues.put("amount", amount);
        contentValues.put("date_", DeliveryDate);
        contentValues.put("status", status);

        try {
            shoppingManager.addRow(ORDER_TABLE, contentValues);
        }
        catch (Exception e)
        {
            Log.i("Error: ",e.getMessage());

        }

    }

    public static void addCustomer(String fName, String lName, String address, String postalCode,String userName,
                                   String password){
        Random customerID = new Random();
        int randomInt = customerID.nextInt(900) + 1;
        customerid.setCustomerID(randomInt);
        ContentValues contentValues = new ContentValues();
        contentValues.put("customerID", randomInt);
        contentValues.put("userName",userName);
        contentValues.put("password",password);
        contentValues.put("firstName",fName);
        contentValues.put("lastName",lName);
        contentValues.put("address",address);
        contentValues.put("postalCode",postalCode);
        try {

            shoppingManager.addRow(CUSTOMER_TABLE,contentValues);
            shoppingManager.close();
        }
        catch (Exception e){

            Log.i("Error: ",e.getMessage());

        }
    }
    public static void addOrderRep(String fName, String lName, String userName, String password){
        Random employeeID = new Random();
        int randomInt = employeeID.nextInt(900) + 1;
        ContentValues contentValues = new ContentValues();
        contentValues.put("employeeID", randomInt);
        contentValues.put("userName",userName);
        contentValues.put("password",password);
        contentValues.put("firstName",fName);
        contentValues.put("lastName",lName);

        try {

            shoppingManager.addRow(ORDERREP_TABLE,contentValues);
        }
        catch (Exception e)
        {
            Log.i("Error: ",e.getMessage());

        }
    }

    public static void addItem(String itemName, Integer price, String category)
    {
        Random itemID = new Random();
        int randomInt = itemID.nextInt(900) + 1;
        ContentValues contentValues = new ContentValues();
        contentValues.put("itemID", randomInt);
        contentValues.put("itemName", itemName);
        contentValues.put("price", price);
        contentValues.put("category", category);
        try
        {
            shoppingManager.addRow(ITEM_TABLE, contentValues);
        }
        catch(Exception e)
        {
            Log.i("Error: ",e.getMessage());

        }


    }

    public void reDirectCustomer (View view ){
        // Do something in response to button

        Intent intent = new Intent(this, Customer.class);
        //switch scenes
        startActivity(intent);

    }

    public void reDirectRepresentative (View view ){
        // Do something in response to button

        Intent intent = new Intent(this, Representative.class);
        //switch scenes
        startActivity(intent);

    }
}
