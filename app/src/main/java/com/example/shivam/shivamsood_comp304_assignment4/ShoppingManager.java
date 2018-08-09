package com.example.shivam.shivamsood_comp304_assignment4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ShoppingManager extends SQLiteOpenHelper {

    //database name and version
    private static final String DATABASE_NAME = "ShoppingDB";
    private static final int DATABASE_VERSION = 1;
    // table name and table creator string (SQL statement to create the table)
    // should be set from within main activity
    //customer Table
    private final static String CUSTOMER_TABLE = "Customers ";
    private static final String CustomerTableString =
            "CREATE TABLE "+ CUSTOMER_TABLE +
                    " (customerID integer primary key, userName text , password text, " +
                    "firstName text, lastName text, address text, postalCode text);";
    //orderRep Table
    private final static String ORDERREP_TABLE = "OrderRep ";
    private static final String OrderRepTableSting =
            "CREATE TABLE "+ ORDERREP_TABLE +
                    " (employeeID integer primary key, userName text , password text, " +
                    "firstName text, lastName text);";

    //item Table
    private final static String ITEM_TABLE = "Item";
    private static final String ItemTableString =
            "CREATE TABLE "+ ITEM_TABLE +  " (itemID integer primary key,  itemName text , price integer , " +
                    "Category text,   CONSTRAINT name_unique UNIQUE (itemName));";

    private final static String ORDER_TABLE = "Order_"; //keyword Order not working
    private static final String orderTableString = "Create TABLE " + ORDER_TABLE + "(orderID integer primary key, item_ID integer, customer_ID integer, amount integer, date_ Text, status Text);";



    private static String tableName;
    private static String tableCreatorString;

    public ShoppingManager(Context context)
    {
        super (context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    //Execute the table once it is called for the first time
    @Override
    public void onCreate(SQLiteDatabase db) {
        //create the table
        // db.execSQL(tableCreatorString);

        db.execSQL(CustomerTableString);
        db.execSQL(OrderRepTableSting);
        db.execSQL(ItemTableString);
        db.execSQL(orderTableString);
    }
    // Called when the database needs to be upgraded.
    // The implementation should use this method to drop tables,
    // add tables, or do anything else it needs to upgrade
    // to the new schema version.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //drop table if existed
        //  db.execSQL("DROP TABLE IF EXISTS " + tableName);

        db.execSQL("DROP TABLE IF EXISTS " + CUSTOMER_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + ORDERREP_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + ITEM_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + ORDER_TABLE);

        //recreate the table
        onCreate(db);
    }
//initialize the table Name, and create Table Statement

    public void dbInitialize(String tableName, String tableCreatorString)
    {
        this.tableName = tableName;
        this.tableCreatorString = tableCreatorString;
    }

    //Adding a row to the table
    //when Doing addRow put the table name and the Content Values in the Method Parameters
    public boolean addRow  (String tableName, ContentValues values) throws Exception {
        SQLiteDatabase db = this.getWritableDatabase();
        // Insert the row
        long nr= db.insert(tableName, null, values);

        db.close(); //close database connection
        return nr> -1;
    }
    public Customer_obj  getCustomerById(Object id, String fieldName) throws Exception {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + CUSTOMER_TABLE + " where " + fieldName
                + " = "+"'" + String.valueOf(id) + "'", null);

        // Cursor cursor =  db.rawQuery( "select * from " + tableName + " where "+ fieldName + "='"+String.valueOf(id)+"'", null );
        Customer_obj customer = new Customer_obj();
        if (cursor.moveToFirst())
        {
            cursor.moveToFirst();
            customer.setCustomerID(cursor.getInt(0));
            customer.setuserName(cursor.getString(1));
            customer.setpassword(cursor.getString(2));
            customer.setfirstName(cursor.getString(3));
            customer.setlastName(cursor.getString(4));
            customer.setaddress(cursor.getString(5));
            customer.setpostalCode(cursor.getString(6));



        }

        else {
            customer = null;
        }
        db.close();
        return customer;


    }

    public Order_obj getorderById(Object id, String fieldName) throws Exception {
        SQLiteDatabase db = this.getReadableDatabase();

        //Change tableName to OrderRep
        Cursor cursor = db.rawQuery("select * from " + ORDERREP_TABLE + " where " + fieldName
                + " = "+"'" + String.valueOf(id) + "'", null);

        Order_obj orderRep = new Order_obj();
        if (cursor.moveToFirst())
        {
            orderRep.setemployeeID(cursor.getInt(0));
            orderRep.setuserName(cursor.getString(1));
            orderRep.setpassword(cursor.getString(2));
            orderRep.setfirstName(cursor.getString(3));
            orderRep.setlastName(cursor.getString(4));

        }
        else{
            orderRep = null;
        }
        db.close();
        return orderRep;

    }
    public boolean editRow (Object id, String fieldName, ContentValues values) throws Exception {
        SQLiteDatabase db = this.getWritableDatabase();
        //
        int nr = db.update(tableName, values, fieldName + " = ? ", new String[]{String.valueOf(id)});
        return nr > 0;
    }




    public Cursor getAllRecords() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("select * from " +  tableName, null);

    }
    public void delete( String Table, String fieldname, int name)
    {        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("Delete From " + Table + " where " + fieldname + " = " + name );
    }

    public OrderItem_obj  getOrderItemById(Object id, String fieldName) throws Exception {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + ORDER_TABLE + " where " + fieldName
                + " = "+"'" + String.valueOf(id) + "'", null);


        // Cursor cursor =  db.rawQuery( "select * from " + tableName + " where "+ fieldName + "='"+String.valueOf(id)+"'", null );
        OrderItem_obj orderItem = new OrderItem_obj();
        if (cursor.moveToFirst())
        {
            cursor.moveToFirst();
            orderItem.setOrderItemID(cursor.getInt(0));
            orderItem.setItemID(cursor.getInt(1));
            orderItem.setCustomerID(cursor.getInt(2));
            orderItem.setAmount(cursor.getInt(3));
            orderItem.setDeliveryDate(cursor.getString(4));
            orderItem.setStatus(cursor.getString(5));
        }

        else {
            orderItem = null;
        }
        db.close();
        return orderItem;


    }
}
