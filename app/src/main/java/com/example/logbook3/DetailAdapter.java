package com.example.logbook3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.DetailViewHolder> {
    private Context context;
    private ArrayList<DetailModel> mDetailList;

    public DetailAdapter(Context context,  ArrayList<DetailModel>mDetailList) {
        this.context = context;
        this.mDetailList = mDetailList;
    }

    @NonNull
    @Override
    public DetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_detail_adapter, parent, false);
        return new DetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailViewHolder holder, int position) {
        DetailModel detailModel = mDetailList.get(position);
        if (detailModel == null){
            return;
        }
        holder.name.setText(detailModel.getName());
        holder.birthday.setText(detailModel.getBirthday());
        holder.email.setText(detailModel.getEmail());

    }

    @Override
    public int getItemCount() {
        return mDetailList.size();
    }
    class DetailViewHolder extends RecyclerView.ViewHolder {
        private TextView name, birthday, email;

        public DetailViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            birthday = itemView.findViewById(R.id.birthday);
            email = itemView.findViewById(R.id.email);


        }
    }

}