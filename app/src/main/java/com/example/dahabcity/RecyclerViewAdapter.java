package com.example.dahabcity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    Context context;
    ArrayList<DataModel> dataModelArrayList;

    public RecyclerViewAdapter(ArrayList<DataModel> data, Context context) {

        dataModelArrayList = data;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.recycler_view_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final DataModel dataModel = dataModelArrayList.get(position);
        holder.textView.setText(dataModelArrayList.get(position).getTitle());
        holder.imageView.setImageResource(dataModelArrayList.get(position).getImageResourceId());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,ModelPage.class);
                intent.putExtra(context.getString(R.string.title_key), dataModel.getTitle());
                intent.putExtra(context.getString(R.string.description_key), dataModel.getDescription());
                intent.putExtra(context.getString(R.string.image_key), dataModel.getImageResourceId());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataModelArrayList.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }


}
