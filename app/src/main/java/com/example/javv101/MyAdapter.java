package com.example.javv101;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    ArrayList<User> list;

    public MyAdapter(Context context, ArrayList<User> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        User user= list.get(position);
        holder.fullName.setText(user.getFullName());
        holder.age.setText(user.getAge());
        holder.phoneNumber.setText(user.getPhoneNumber());
        holder.email.setText(user.getEmail());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView fullName, age, phoneNumber, email, gender;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            fullName=itemView.findViewById(R.id.tfullnames);
            age=itemView.findViewById(R.id.tage);
            phoneNumber=itemView.findViewById(R.id.tphone);
            email=itemView.findViewById(R.id.temail);
            gender=itemView.findViewById(R.id.tgender);
        }
    }


}
