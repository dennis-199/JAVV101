package com.example.javv101;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.hanks.passcodeview.PasscodeView;

public class Saccos extends AppCompatActivity {
    PasscodeView passcodeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saccos);

        passcodeView = findViewById(R.id.passcode_view);

        passcodeView.setPasscodeLength(4)
        .setLocalPasscode("1234")
        .setListener(new PasscodeView.PasscodeViewListener() {
            @Override
            public void onFail() {
                Toast.makeText(getApplicationContext(),"Wrong Password",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(String number) {
                Intent intent=new Intent(Saccos.this,Saccospage.class);
                startActivity(intent);

            }
        });
    }
}