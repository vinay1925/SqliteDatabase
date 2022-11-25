package com.example.sqldatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editText;

    Button button,btnView;
    //ListView listView;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.edittxt);
        button=findViewById(R.id.button);
        btnView=findViewById(R.id.btnView);
        databaseHelper=new DatabaseHelper(this);

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, ViewListContents.class);
startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry =editText.getText().toString();
                if (editText.length()!=0) {
                    AddData(newEntry);
                    editText.setText("");
                }else {
                    Toast.makeText(MainActivity.this, "You must put something in the text field", Toast.LENGTH_SHORT).show();

                }
        }});
        }

    private void AddData(String newEntry) {
        boolean insertData=databaseHelper.addData(newEntry);
        if (insertData) {
            Toast.makeText(MainActivity.this, "Successfully Entered data", Toast.LENGTH_SHORT).show();
        }else {

            Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();

        }
    }
}