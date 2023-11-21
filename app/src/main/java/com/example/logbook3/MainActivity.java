package com.example.logbook3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Calendar selectedDate = Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText birthdayTxt = (EditText) findViewById(R.id.editTextBirthday);
        birthdayTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int day) {

                                selectedDate.set(Calendar.YEAR, year);
                                selectedDate.set(Calendar.MONTH, month);
                                selectedDate.set(Calendar.DAY_OF_MONTH, day);

                                birthdayTxt.setText(SimpleDateFormat.getDateInstance().format(selectedDate.getTime()));

                            }
                        },
                        selectedDate.get(Calendar.YEAR),
                        selectedDate.get(Calendar.MONTH),
                        selectedDate.get(Calendar.DAY_OF_MONTH)
                );
                datePickerDialog.show();
            }
        });

        Button savebtn = (Button) findViewById(R.id.button_save);
        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveDetails();
            }
        });

        Button viewbtn = (Button) findViewById(R.id.button4);
        viewbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){viewDetails();}
        });
    }

    private void saveDetails(){
        DatabaseHelper dbHelper = new DatabaseHelper(getApplicationContext());
        EditText nameTxt = (EditText) findViewById(R.id.editTextName);
        EditText birthdayTxt = (EditText) findViewById(R.id.editTextBirthday);
        EditText emailTxt = (EditText) findViewById(R.id.editTextEmail);


        String name = nameTxt.getText().toString();
        String birthday = birthdayTxt.getText().toString();
        String email = emailTxt.getText().toString();


        long personId = dbHelper.insertDetails(name, email, birthday);
        Toast.makeText(this, "Person has been created with id:" + personId, Toast.LENGTH_LONG).show();

        Intent i = new Intent(this, Details.class);
        startActivity(i);
    }

    private void viewDetails(){
        Intent h = new Intent(this, Details.class);
        startActivity(h);
    }
}