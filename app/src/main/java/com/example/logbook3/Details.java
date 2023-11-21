package com.example.logbook3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;

public class Details extends AppCompatActivity {
    RecyclerView recyclerView;
    DetailAdapter adapter;
    DatabaseHelper dbHelper;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        dbHelper = new DatabaseHelper(this);

        recyclerView = findViewById(R.id.recyclerView);

        ArrayList<DetailModel> mDetailList = getDetailsFromDatabase();

        adapter = new DetailAdapter(this, mDetailList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<DetailModel> getDetailsFromDatabase() {
        ArrayList<DetailModel> mDetailList = new ArrayList<>();

        sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT Name, Birthday, Email FROM contact_details", null);

        if (cursor.moveToFirst()) {
            int nameIndex = cursor.getColumnIndex("name");
            int birthdayIndex = cursor.getColumnIndex("birthday");
            int emailIndex = cursor.getColumnIndex("email");


            if (nameIndex >= 0 && emailIndex >= 0 && birthdayIndex >= 0) {
                do {
                    String name = cursor.getString(nameIndex);
                    String birthday = cursor.getString(birthdayIndex);
                    String email = cursor.getString(emailIndex);


                    DetailModel detailModel = new DetailModel();
                    detailModel.setName(name);
                    detailModel.setBirthday(birthday);
                    detailModel.setEmail(email);


                    mDetailList.add(detailModel);
                } while (cursor.moveToNext());
            }
        }

        cursor.close();
        sqLiteDatabase.close();

        return mDetailList;
    }
}
