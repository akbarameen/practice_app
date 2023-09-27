package com.example.wasooli_aab.customer;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.example.wasooli_aab.R;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wasooli_aab.dummyList.DummyListModel;

import java.io.Serializable;
import java.util.ArrayList;

public class RVCustomerAdapter  extends RecyclerView.Adapter<RVCustomerAdapter.ViewHolder> {

    Context context;
    private ArrayList<DummyListModel> customersList;


    public RVCustomerAdapter(Context context, ArrayList<DummyListModel> customersList) {
        this.context = context;
        this.customersList = customersList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_customer_row_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        DummyListModel item = customersList.get(position);
        holder.tvName.setText(item.getName());
        holder.tvAddress.setText(item.getAddress());
        holder.tvCell.setText(item.getCellPhone());
        holder.tvQuantity.setText(String.valueOf(item.getA1()));

        // updating the data on normal click
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AddEditCustomerActivity.class);
                intent.putExtra("editData", item);
                v.getContext().startActivity(intent);
            }
        });

        // deleting data on Long CLick
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("Confirmation")
                        .setMessage("Are you sure you want to remove this item?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Remove the item from the dataList
                                customersList.remove(position);
                                // Notify the adapter
                                notifyItemRemoved(position);
                                notifyItemRangeChanged(position, customersList.size());
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Dismiss the dialog (nothing will happen)
                                dialog.dismiss();
                            }
                        })
                        .show();
                return true;
            }
        });

        // update and delete
//        holder.menuButton.setOnClickListener(new View.OnClickListener() {
//            @SuppressLint("RestrictedApi")
//            @Override
//            public void onClick(View v) {
//                // Show the menu
//                PopupMenu popupMenu = new PopupMenu(context, holder.menuButton, Gravity.END, 0, R.style.PopupMenuStyle);
//                popupMenu.getMenuInflater().inflate(R.menu.rv_item_menu, popupMenu.getMenu());
//
//                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//                    @Override
//                    public boolean onMenuItemClick(MenuItem item) {
//                        int id = item.getItemId();
//
//                        if (id == R.id.btn_edit) {
//                            //edit data
//                            Intent intent = new Intent(v.getContext(), AddEditCustomerActivity.class);
//                            intent.putExtra("editData", (Serializable) item);
//                            v.getContext().startActivity(intent);
//
//                            return true;
//                        } else if (id ==R.id.btn_delete) {
//                            AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
//                            builder.setTitle("Confirmation")
//                                    .setMessage("Are you sure you want to remove this item?")
//                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                                        @Override
//                                        public void onClick(DialogInterface dialog, int which) {
//                                            // Remove the item from the dataList
//                                            customersList.remove(position);
//                                            // Notify the adapter
//                                            notifyItemRemoved(position);
//                                            notifyItemRangeChanged(position, customersList.size());
//                                        }
//                                    })
//                                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
//                                        @Override
//                                        public void onClick(DialogInterface dialog, int which) {
//                                            // Dismiss the dialog (nothing will happen)
//                                            dialog.dismiss();
//                                        }
//                                    })
//                                    .show();
//                            return true;
//
//                        }
//
//                        return false;
//                    }
//                });
//
//                popupMenu.show();
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return customersList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvAddress, tvCell, tvQuantity;
        ImageView menuButton;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvAddress = itemView.findViewById(R.id.tv_address);
            tvCell = itemView.findViewById(R.id.tv_cell);
            tvQuantity = itemView.findViewById(R.id.tv_quantity);
            menuButton = itemView.findViewById(R.id.menu_button);
        }
    }
}

