package com.example.wasooli_aab.Delivery;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.wasooli_aab.R;
import com.example.wasooli_aab.dummyList.DummyListModel;

import java.util.ArrayList;

public class DeliveryAdapter extends RecyclerView.Adapter<DeliveryAdapter.ViewHolder> {
    private ArrayList<DummyListModel> dataList;

    public DeliveryAdapter(ArrayList<DummyListModel> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_delivery_row_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        DummyListModel item = dataList.get(position);
        holder.tvName.setText(item.getName());
        holder.tvAddress.setText(item.getAddress());
        holder.tvQuantity.setText(String.valueOf(item.getA1()));
        holder.tvBalance.setText(String.valueOf(item.getAmount()));

        // Set OnClickListener on item view
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start DeliveryDetailActivity
                Intent intent = new Intent(v.getContext(), DeliveryDetailsActivity.class);
                intent.putExtra("position", position); // Optionally, pass any data you need
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvAddress, tvQuantity, tvBalance;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvAddress = itemView.findViewById(R.id.tv_address);
            tvQuantity = itemView.findViewById(R.id.tv_quantity);
            tvBalance = itemView.findViewById(R.id.tv_balance);
        }
    }
}
