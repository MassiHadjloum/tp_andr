package com.example.webservice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ItemShowAdapter extends RecyclerView.Adapter<ItemShowAdapter.ItemShowViewHolder>{


    private Context context;
    private List<ItemShow> itemShowList;

    public ItemShowAdapter(Context context, List<ItemShow> itemShowList) {
        this.context = context;
        this.itemShowList = itemShowList;
    }

    @NonNull
    @Override
    public ItemShowAdapter.ItemShowViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item,
                parent,
                false
        );

        ItemShowViewHolder itemShowViewHolder = new ItemShowViewHolder(view);

        return itemShowViewHolder;
    }



    @Override
    public void onBindViewHolder(@NonNull ItemShowAdapter.ItemShowViewHolder holder, int position) {
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$");
        ItemShow tvShow = itemShowList.get(position);
        holder.nameText.setText(tvShow.getName());

        Glide.with(context)
                .load(tvShow.getImageUrl())
                .placeholder(R.drawable.placeholder)
                .centerCrop()
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return itemShowList.size();
    }

    public class ItemShowViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView nameText;

        public ItemShowViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_thumbnail_path);
            nameText = itemView.findViewById(R.id.name);

        }
    }

}
