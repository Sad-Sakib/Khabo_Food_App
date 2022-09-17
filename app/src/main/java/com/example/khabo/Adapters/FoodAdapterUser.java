package com.example.khabo.Adapters;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.khabo.Models.FoodModelUser;
import com.example.khabo.R;

import java.util.ArrayList;

public class FoodAdapterUser extends RecyclerView.Adapter<FoodAdapterUser.viewholder> {
    ArrayList<FoodModelUser> listUser;
    Context context;

    public FoodAdapterUser(ArrayList<FoodModelUser> listUser, Context context) {
        this.listUser = listUser;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_foodlist_user,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        final FoodModelUser model= listUser.get(position);
        holder.fdimage.setImageResource(model.getImage());
        holder.name.setText(model.getName());
        holder.price.setText(model.getPrice());

    }

    @Override
    public int getItemCount() {
        return listUser.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
        ImageView fdimage;
        TextView name,price;

        public viewholder(@NonNull View itemView) {
            super(itemView);

            fdimage=itemView.findViewById(R.id.imageViewUser);
            name=itemView.findViewById(R.id.nameUser);
            price=itemView.findViewById(R.id.order_priceUser);
        }
    }
}
