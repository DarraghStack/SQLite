package com.example.sqlite;

import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class CopyDbActivity extends AppCompatActivity {

    Cursor c = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_copydb);

        ((Button) findViewById(R.id.button01)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper myDbHelper = new DatabaseHelper(CopyDbActivity.this);
                try {
                    myDbHelper.createDataBase();
                } catch (IOException ioe) {
                    throw new Error("Unable to create database");
                }
                try {
                    myDbHelper.openDataBase();
                } catch (SQLException sqle) {
                    throw sqle;
                }
                Toast.makeText(CopyDbActivity.this, "Successfully Imported", Toast.LENGTH_SHORT).show();
                c = myDbHelper.query("Price14022021", null, null, null, null, null, null);
                if (c.moveToFirst()) {
                    do {
                        Toast.makeText(CopyDbActivity.this,
                                "Product Name " + c.getString(0) + "\n" +
                                        "SV_Price: " + c.getString(1) + "\n" +
                                        "Aldi_Price " + c.getString(2) + "\n" +
                                        "Tesco-Price" + c.getString(3),
                                Toast.LENGTH_LONG).show();
                    } while (c.moveToNext());
                }
            }
        });
    }
}