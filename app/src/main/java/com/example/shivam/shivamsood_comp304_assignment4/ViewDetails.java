package com.example.shivam.shivamsood_comp304_assignment4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ViewDetails extends AppCompatActivity  implements AdapterView.OnItemClickListener{

    ListView lstOrders;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);

        lstOrders = findViewById(R.id.lstOrders);
        lstOrders.setOnItemClickListener(this);
    }
    public void LoadOrders(){


    }
    public void onItemClick(AdapterView<?> l, View v, int position, long id) {
        Log.i("HelloListView", "You clicked Item: " + id + " at position:" + position);
        Toast.makeText(ViewDetails.this,
                "Clicked", Toast.LENGTH_SHORT).show();
        Intent i = new Intent();

    }
}
