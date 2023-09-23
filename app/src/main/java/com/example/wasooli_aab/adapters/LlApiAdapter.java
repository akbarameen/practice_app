package com.example.wasooli_aab.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wasooli_aab.R;
import com.example.wasooli_aab.models.LlApiModel;

import java.util.ArrayList;

public class LlApiAdapter extends RecyclerView.Adapter<LlApiAdapter.ViewHolder> {

    Context context;
    private ArrayList<LlApiModel> llApiDataList;

    public LlApiAdapter(Context context, ArrayList<LlApiModel> llApiDataList) {
        this.context = context;
        this.llApiDataList = llApiDataList;
    }

    @NonNull
    @Override
    public LlApiAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ll_api_item_row, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull LlApiAdapter.ViewHolder holder, int position) {
        LlApiModel data = llApiDataList.get(position);
        holder.tvId.setText(String.valueOf(data.getId()));
        holder.tvName.setText(data.getName());
        holder.tvFName.setText(data.getfName());
        String gender = data.getGender();
        if (gender.equals("M")) {
            holder.tvGender.setText("Male");
        }else {
            holder.tvGender.setText("Female");
        }

    }

    @Override
    public int getItemCount() {
        return llApiDataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvId, tvName, tvFName, tvGender;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tv_id);
            tvName = itemView.findViewById(R.id.tv_name);
            tvFName = itemView.findViewById(R.id.tv_fName);
            tvGender = itemView.findViewById(R.id.tv_gender);

        }
    }

}
