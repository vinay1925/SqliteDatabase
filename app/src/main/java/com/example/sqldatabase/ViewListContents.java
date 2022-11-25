package com.example.sqldatabase;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ViewListContents extends AppCompatActivity {
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewcontents_layout);

        ListView listView=(ListView) findViewById(R.id.ListView);
        databaseHelper=new DatabaseHelper(this);
        ArrayList<String> theList=new ArrayList<>();
        Cursor data=databaseHelper.getListContents();
        if (data.getCount()==0) {
            Toast.makeText(ViewListContents.this, "the database wsa empty", Toast.LENGTH_SHORT).show();
        }else {
           while (data.moveToNext()){
               theList.add(data.getString(1));
               ListAdapter listAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,theList);
              // ListAdapter listAdapter1=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,theList);

               listView.setAdapter(listAdapter);
               //listView.setAdapter(listAdapter1);
           }
        }
    }
}
