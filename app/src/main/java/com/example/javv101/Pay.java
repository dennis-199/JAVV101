package com.example.javv101;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Pay extends AppCompatActivity {
    ArrayList<String> saccosname=new ArrayList<>();
    ArrayList<String> vehiclesno=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        //SPINNER
        Spinner sp= (Spinner) findViewById(R.id.spinner3);
        Spinner sp2=(Spinner) findViewById(R.id.spinner4);

        //FILL DATA
        fillData();

        //ADAPTR
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,saccosname);
        sp.setAdapter(adapter);
        ArrayAdapter<String> adapter1=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,vehiclesno);
        sp2.setAdapter(adapter1);

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
    }

    //FILL DATA
    private void fillData()
    {
        saccosname.clear();
        vehiclesno.clear();

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

    }
}
