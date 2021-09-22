package com.example.javv101;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Payingdetails extends AppCompatActivity {
    private Button paying;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payingdetails);

        paying=(Button) findViewById(R.id.paying);
        paying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Payingdetails.this,MpesaActivity.class);
                startActivity(intent);


            }
        });
    }
}