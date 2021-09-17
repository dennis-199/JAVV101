package com.example.javv101;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Booktrip extends AppCompatActivity {
    ArrayList<String> destinations=new ArrayList<>();
    ArrayList<String> pickuppoints=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booktrip);

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