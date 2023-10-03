package com.example.wasooli_aab.newCustomers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wasooli_aab.R;
import com.example.wasooli_aab.dummyList.DummyListModel;

import java.util.List;

public class RVCustomersAdapter extends RecyclerView.Adapter<RVCustomersAdapter.ViewHolder> {
    private List<DummyListModel> dataList;

    public RVCustomersAdapter(List<DummyListModel> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_customers_row_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DummyListModel item = dataList.get(position);

        holder.tvName.setText(item.getName());
        holder.tvAddress.setText(item.getAddress());
        holder.tvCellphone.setText(item.getCellPhone());
        holder.tvDate.setText(item.getDate().toString()); // Assuming date is stored as a String
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvAddress, tvCellphone, tvDate;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvAddress = itemView.findViewById(R.id.tv_address);
            tvCellphone = itemView.findViewById(R.id.tv_cellphone);
            tvDate = itemView.findViewById(R.id.tv_date);
        }
    }
}
