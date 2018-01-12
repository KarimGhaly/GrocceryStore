package com.example.mac.groccerystore.view.mainactivity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mac.groccerystore.R;
import com.example.mac.groccerystore.data.model.local.Item;

import java.util.List;

/**
 * Created by mac on 1/11/18.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    List<Item> itemList;

    public Adapter(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
            Item item = itemList.get(position);
            holder.txtTitle.setText(item.getName());
            holder.txtBody.setText(item.getShortDescription());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtTitle;
        TextView txtBody;
        public ViewHolder(View itemView) {
            super(itemView);
            txtTitle  = itemView.findViewById(R.id.txtTitle);
            txtBody = itemView.findViewById(R.id.txtBody);
        }
    }
}
