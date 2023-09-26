package com.example.wasooli_aab.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.wasooli_aab.R;
import com.example.wasooli_aab.models.HomeModel;
import java.util.ArrayList;

public class RVHomeAdapter extends  RecyclerView.Adapter<RVHomeAdapter.ViewHolder>{

    Context context;
    private final ArrayList<HomeModel> homeModelArrayList;

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

       holder.menuButton.setOnClickListener(new View.OnClickListener() {
           @SuppressLint("RestrictedApi")
           @Override
           public void onClick(View v) {
               // Show the menu
               PopupMenu popupMenu = new PopupMenu(context, holder.menuButton, Gravity.END, 0, R.style.PopupMenuStyle);
               popupMenu.getMenuInflater().inflate(R.menu.rv_item_menu, popupMenu.getMenu());

               popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                   @Override
                   public boolean onMenuItemClick(MenuItem item) {
                       int id = item.getItemId();

                       if (id == R.id.btn_edit) {
                           // Handle the menu item click here
                           return true;
                       }

                       return false;
                   }
               });

               popupMenu.show();
               }
       });
    }

    @Override
    public int getItemCount() {
        return homeModelArrayList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvName, tvAddress, tvCell;
        ImageView menuButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            menuButton = itemView.findViewById(R.id.menu_button);
            tvName = itemView.findViewById(R.id.tv_name);
            tvAddress = itemView.findViewById(R.id.tv_address);
            tvCell = itemView.findViewById(R.id.tv_cell);

        }
    }

}
