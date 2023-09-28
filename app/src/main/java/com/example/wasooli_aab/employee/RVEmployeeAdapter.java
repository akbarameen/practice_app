package com.example.wasooli_aab.employee;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wasooli_aab.R;
import com.example.wasooli_aab.customer.AddEditCustomerActivity;
import com.example.wasooli_aab.dummyList.DummyListModel;

import java.util.ArrayList;

public class RVEmployeeAdapter extends RecyclerView.Adapter<RVEmployeeAdapter.ViewHolder> {

    Context context;
    private ArrayList<DummyListModel> dataList;
    public RVEmployeeAdapter(Context context, ArrayList<DummyListModel> employeesList) {
        this.context = context;
        this.dataList = employeesList;
    }
    @NonNull
    @Override
    public RVEmployeeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_employee_row_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVEmployeeAdapter.ViewHolder holder, int position) {
        DummyListModel item = dataList.get(position);
        holder.tvName.setText(item.getName());
        holder.tvAddress.setText(item.getAddress());
        holder.tvCell.setText(item.getCellPhone());
        holder.tvDate.setText(item.getDate().toString());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AddEditEmployeeActivity.class);
                intent.putExtra("editData", item);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvAddress, tvCell, tvDate;
//        ImageView menuButton;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvAddress = itemView.findViewById(R.id.tv_address);
            tvCell = itemView.findViewById(R.id.tv_cell);
            tvDate = itemView.findViewById(R.id.tv_date);
//            menuButton = itemView.findViewById(R.id.menu_button);
        }
    }

    // Method to delete item
    public void deleteItem(int position) {
        dataList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, dataList.size());
    }

}
