package com.example.wasooli_aab.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wasooli_aab.R;

import com.example.wasooli_aab.models.HomeModel;

import java.util.ArrayList;

public class RVHomeAdapter extends  RecyclerView.Adapter<RVHomeAdapter.ViewHolder>{

    Context context;
    private ArrayList<HomeModel> homeModelArrayList;

    public RVHomeAdapter(Context context, ArrayList<HomeModel> homeModelArrayList) {
        this.context = context;
        this.homeModelArrayList = homeModelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_home_row_item, parent, false);
        return new ViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       HomeModel data = homeModelArrayList.get(position);
       holder.tvName.setText(data.getName());
       holder.tvAddress.setText(data.getAddress());
       holder.tvCell.setText(data.getCellPhone());


    }

    @Override
    public int getItemCount() {
        return homeModelArrayList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvName, tvAddress, tvCell;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_name);
            tvAddress = itemView.findViewById(R.id.tv_address);
            tvCell = itemView.findViewById(R.id.tv_cell);

        }
    }

}
