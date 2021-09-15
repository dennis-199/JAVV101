package com.example.javv101;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener{

    private FirebaseUser user;
    private DatabaseReference reference;
    private String userID;
    private CardView booking,payment,viewBookings,driver,saccos,logout;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);



        logout = (CardView) findViewById(R.id.signOut);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(ProfileActivity.this, MainActivity.class));

            }
        });



        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();

        final TextView greetingTextView = (TextView) findViewById(R.id.greeting);

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userprofile = snapshot.getValue(User.class);

                if(userprofile != null){
                    String fullname = userprofile.fullName;

                    greetingTextView.setText("WELCOME  " + fullname + "!");

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                
            }


        });
        booking=findViewById(R.id.booking);
        payment=findViewById(R.id.payment);
        viewBookings=findViewById(R.id.viewbookings);
        driver=findViewById(R.id.driver);
        saccos=findViewById(R.id.saccos);

        booking.setOnClickListener(this);
        payment.setOnClickListener(this);
        viewBookings.setOnClickListener(this);
        driver.setOnClickListener(this);
        saccos.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()){
            case R.id.booking:i=new Intent(this,Booktrip.class);startActivity(i);
            break;
            case R.id.payment:i=new Intent(this,Pay.class);startActivity(i);
            break;
            case R.id.viewbookings:i=new Intent(this,Viewbookings.class);startActivity(i);
            break;
            case R.id.driver:i=new Intent(this,Driver.class);startActivity(i);
            break;
            case R.id.saccos:i=new Intent(this,Saccos.class);startActivity(i);
            default:break;
        }

    }
}
