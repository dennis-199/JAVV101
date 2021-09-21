package com.example.javv101;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Pay extends AppCompatActivity {
    ArrayList<String> saccosname=new ArrayList<>();
    ArrayList<String> vehiclesno=new ArrayList<>();
    ArrayList<String> pickuppoint=new ArrayList<>();
    ArrayList<String> destinationpoint=new ArrayList<>();
    private Button paybutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        //SPINNER
        Spinner sp= (Spinner) findViewById(R.id.spinner3);
        Spinner sp2=(Spinner) findViewById(R.id.spinner4);
        Spinner sp3=(Spinner) findViewById(R.id.spinner5);
        Spinner sp4=(Spinner) findViewById(R.id.spinner6);

        //FILL DATA
        fillData();

        //ADAPTR
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,saccosname);
        sp.setAdapter(adapter);
        ArrayAdapter<String> adapter1=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,vehiclesno);
        sp2.setAdapter(adapter1);
        ArrayAdapter<String> adapter2=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, pickuppoint);
        sp3.setAdapter(adapter2);
        ArrayAdapter<String> adapter3=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, destinationpoint);
        sp4.setAdapter(adapter3);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Pay.this, saccosname.get(i), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Pay.this, vehiclesno.get(i), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        sp3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Pay.this, pickuppoint.get(i), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        sp4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Pay.this, destinationpoint.get(i), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        paybutton =(Button) findViewById(R.id.paybutton);
        paybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Pay.this,Payingdetails.class);
                startActivity(intent);
            }
        });
    }

    //FILL DATA
    private void fillData()
    {
        saccosname.clear();
        vehiclesno.clear();
        pickuppoint.clear();


        //FILL
        saccosname.add("Highrise");
        saccosname.add("Buruburu");
        saccosname.add("Kinatwa");
        saccosname.add("Agape");
        saccosname.add("2 NK");
        saccosname.add("St.Mary's");
        saccosname.add("South B Travellers");
        saccosname.add("Embassavo");
        saccosname.add("Kileleshwa");
        saccosname.add("city hoppa");
        saccosname.add("city shuttle");
        saccosname.add("Ruiru");


        vehiclesno.add("A1");
        vehiclesno.add("A2");
        vehiclesno.add("A3");
        vehiclesno.add("A4");
        vehiclesno.add("A5");
        vehiclesno.add("A6");
        vehiclesno.add("A7");
        vehiclesno.add("A9");
        vehiclesno.add("A10");
        vehiclesno.add("B1");
        vehiclesno.add("B2");
        vehiclesno.add("B3");
        vehiclesno.add("B4");
        vehiclesno.add("B5");
        vehiclesno.add("B6");
        vehiclesno.add("B7");
        vehiclesno.add("B8");
        vehiclesno.add("B9");
        vehiclesno.add("B10");

        pickuppoint.add("BUS Station");
        pickuppoint.add("Bururburu");
        pickuppoint.add("Highrise");
        pickuppoint.add("West Madaraka");
        pickuppoint.add("Langata");
        pickuppoint.add("CBD");
        pickuppoint.add("JUJA");

        destinationpoint.add("BUS Station");
        destinationpoint.add("Bururburu");
        destinationpoint.add("Highrise");
        destinationpoint.add("West Madaraka");
        destinationpoint.add("Langata");
        destinationpoint.add("CBD");
        destinationpoint.add("JUJA");


    }
}
