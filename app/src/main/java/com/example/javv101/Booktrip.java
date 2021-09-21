package com.example.javv101;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.Calendar;

public class Booktrip extends AppCompatActivity {
    ArrayList<String> destinations=new ArrayList<>();
    ArrayList<String> pickuppoints=new ArrayList<>();
    private Button dateButton, timeButton, addbooking, proceedpay;
    private TextView dateTextView, timeTextView, pickup, destination;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseBorrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booktrip);

        addbooking = findViewById(R.id.addbooking);
        dateButton = findViewById(R.id.dateButton);
        timeButton = findViewById(R.id.timeButton);
        dateTextView = findViewById(R.id.dateTextView);
        timeTextView = findViewById(R.id.timeTextView);
        pickup = findViewById(R.id.pickup);
        destination = findViewById(R.id.destination);
        proceedpay=(Button) findViewById(R.id.proceedpay);
        proceedpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Booktrip.this,Payingdetails.class);
                startActivity(intent);
            }
        });

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleDateButton();
            }
        });
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleTimeButton();
            }
        });


        //SPINNER
        Spinner sp= (Spinner) findViewById(R.id.spinner);
        Spinner sp2=(Spinner) findViewById(R.id.spinner2);

        //FILL DATA
        fillData();

        //ADAPTR
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,destinations);
        sp.setAdapter(adapter);
        ArrayAdapter<String> adapter1=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,pickuppoints);
        sp2.setAdapter(adapter1);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Booktrip.this, destinations.get(i), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Booktrip.this, pickuppoints.get(i), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void handleTimeButton() {
        Calendar calendar = Calendar.getInstance();
        int HOUR = calendar.get(Calendar.HOUR);
        int MINUTE = calendar.get(Calendar.MINUTE);
        boolean is24HourFormat = DateFormat.is24HourFormat(this);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                Log.i(TAG, "onTimeSet: " + hour + minute);
                Calendar calendar1 = Calendar.getInstance();
                calendar1.set(Calendar.HOUR, hour);
                calendar1.set(Calendar.MINUTE, minute);
                String dateText = DateFormat.format("h:mm a", calendar1).toString();
                timeTextView.setText(dateText);
            }
        }, HOUR, MINUTE, is24HourFormat);

        timePickerDialog.show();

    }

    private void handleDateButton() {
        Calendar calendar = Calendar.getInstance();
        int YEAR = calendar.get(Calendar.YEAR);
        int MONTH = calendar.get(Calendar.MONTH);
        int DATE = calendar.get(Calendar.DATE);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int date) {

                Calendar calendar1 = Calendar.getInstance();
                calendar1.set(Calendar.YEAR, year);
                calendar1.set(Calendar.MONTH, month);
                calendar1.set(Calendar.DATE, date);
                String dateText = DateFormat.format("EEEE, MMM d, yyyy", calendar1).toString();

                dateTextView.setText(dateText);
            }
        }, YEAR, MONTH, DATE);

        datePickerDialog.show();
    }

    //FILL DATA
    private void fillData()
    {
        destinations.clear();
        pickuppoints.clear();

        //FILL
        destinations.add("Uthiru");
        destinations.add("Kikuyu");
        destinations.add("CBD");
        destinations.add("West Madaraka");
        destinations.add("Westlands");
        destinations.add("Umoja");
        destinations.add("South B");
        destinations.add("Lang'ata");
        destinations.add("Kileleshwa");
        destinations.add("Ngong");
        destinations.add("Juja");
        destinations.add("Ruiru");
        destinations.add("Rongo");
        destinations.add("Oyugis");
        destinations.add("Kisumu");
        destinations.add("Nyeri");
        destinations.add("Machakos");
        destinations.add("Kitui");

        pickuppoints.add("Uthiru");
        pickuppoints.add("Kikuyu");
        pickuppoints.add("CBD");
        pickuppoints.add("West Madaraka");
        pickuppoints.add("Westlands");
        pickuppoints.add("Umoja");
        pickuppoints.add("South B");
        pickuppoints.add("Lang'ata");
        pickuppoints.add("Kileleshwa");
        pickuppoints.add("Ngong");
        pickuppoints.add("Juja");
        pickuppoints.add("Ruiru");
        pickuppoints.add("Rongo");
        pickuppoints.add("Oyugis");
        pickuppoints.add("Kisumu");
        pickuppoints.add("Nyeri");
        pickuppoints.add("Machakos");
        pickuppoints.add("Kitui");

    }
}