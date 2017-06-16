package com.example.manushrivastava.databasestorage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    DatabaseCreate d;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void InsertData(View view)
    {
        d=new DatabaseCreate(getBaseContext());
        ContentValues values = new ContentValues();
        TextView read=(TextView)findViewById(R.id.textView);
        values.put("ID", read.getText().toString());
        db=d.getWritableDatabase();
        db.insert("Version", null,values);

   }
    public void ShowData(View view)
    {
        String a[]=new String[]{"ID"};
        String b[]=new String[]{"NULL"};
        SQLiteDatabase db=d.getReadableDatabase();
        Cursor c=db.query("Version",a,"ID!=?",b,null,null,"ID Desc");


        List itemIds = new ArrayList<>();
        while(c.moveToNext()) {
            itemIds.add(c.getString(c.getColumnIndexOrThrow("ID")));

                  }
        c.close();
        TextView t=(TextView)findViewById(R.id.textView2);
        t.setText(itemIds.get(0).toString());
    }

}
