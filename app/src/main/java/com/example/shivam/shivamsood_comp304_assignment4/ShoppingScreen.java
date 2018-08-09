package com.example.shivam.shivamsood_comp304_assignment4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ShoppingScreen extends AppCompatActivity {
    public ArrayList<String> selectedItems = new ArrayList<>();
    private ArrayList<String> myArrayList = new ArrayList<>();
    private String ItemTable = "Item";
    private String OrderTable = "Order_";
    private ShoppingManager shoppingManager;
    private OrderItem_obj mySetItem;
    Intent intent;
    private String m;
    private String myString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        varInnitiators();

        setContentView(R.layout.activity_shopping_screen);
        SharedPreferences myPref = getSharedPreferences("CustomerMemory", MODE_PRIVATE);
        myString = myPref.getString("CustomerUsername","");
        TextView tView = (TextView)findViewById(R.id.txtShopCus);
        tView.setText("Customer Username: "+myString);

        intent = new Intent(this, OrderInformation.class);

        frontEndvisualization();
    }



    public void placeOrder(View view){
        Cursor cx;
        SQLiteDatabase db = shoppingManager.getReadableDatabase();
        Cursor c2 = db.rawQuery("select CustomerID from customers WHERE userName = ?", new String[]{myString});
        String[] mStringArray = new String[selectedItems.size()];
        mStringArray = selectedItems.toArray(mStringArray);



        cx = db.rawQuery ("select itemID from item Where ItemName = ?" , new String [] {mStringArray[0]});

        try {
            if (c2.moveToFirst())
            {
                c2.moveToLast();
                MainActivity.addOrder(2, c2.getInt(0)  ,
                        3, "12/2/12", "sent" );
            }
            if (cx.moveToFirst())
            {
                cx.moveToLast();
                MainActivity.addOrder(cx.getInt(0), c2.getInt(0 ), 3, "12/2/12", "undelivered");
            }

            Toast.makeText(this, "testsuccess", Toast.LENGTH_SHORT).show();
        }
        catch(Exception e){
            Toast.makeText(this, "testfailed", Toast.LENGTH_SHORT).show();}

        startActivity(intent);



    }
    private void varInnitiators()
    {

        try{
            shoppingManager = new ShoppingManager(this); // Get an instance of the Database Handler
        }
        catch (Exception e)
        {
            Toast.makeText(ShoppingScreen.this,
                    e.getMessage(), Toast.LENGTH_SHORT).show();
            Log.i("Error: ", e.getMessage());
        }


    }

    public void backEndVisualization()
    {

        SQLiteDatabase db = shoppingManager.getReadableDatabase();
        Cursor c =  db.rawQuery( "select * from " + ItemTable, null );
        Item_obj item = new Item_obj();
        try{

            while(!c.isAfterLast   ()) {
                c.moveToNext();
                if (!myArrayList.contains(c.getString(1)))
                {
                    myArrayList.remove(c.getString(1));
                    myArrayList.add(c.getString(1)); //add the item

                    c.close();
                }

            }
        }
        catch(Exception e){

            Log.i("Error: ",e.getMessage());

        }

    }


    public void frontEndvisualization()
    {
        ListView lv = (ListView) findViewById(R.id.checkable_list);
        lv.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);


        try{
            MainActivity.addItem("Jordan", 100 ,"shoe");
            Toast.makeText(ShoppingScreen.this,
                    "Default Item Added", Toast.LENGTH_SHORT).show();
        }
        catch(Exception e)
        {
            Log.i("Error: ",e.getMessage()); };

        backEndVisualization();

        //usual way WORKS WORKS
        // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, getResources().getStringArray(R.array.items));
        //dba way
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, myArrayList);

        //add the values
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = ((TextView) view).getText().toString();
                if(!selectedItems.contains(selectedItem))
                {
                    selectedItems.add(selectedItem);

                }

                //CREATE a cursor that places selectedItem into OrderTable
                intent.putStringArrayListExtra("string-array", selectedItems);
            }
        });


    }

    @Override
    protected void onRestart() {

        // TODO Auto-generated method stub
        super.onRestart();
        Intent i = new Intent(this, ShoppingScreen.class);  //your class
        startActivity(i);
        finish();

    }

}
