package com.example.khabo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.khabo.Adapters.OrdersAdapter;
import com.example.khabo.Models.OrdersModel;
import com.example.khabo.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    ActivityOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<OrdersModel> list = new ArrayList<>();
        list.add(new OrdersModel(R.drawable.fc,"French Fries","120","124" ));
        list.add(new OrdersModel(R.drawable.biryani,"Biryani","200","120" ));
        list.add(new OrdersModel(R.drawable.fc,"French Fries","120","125" ));
        list.add(new OrdersModel(R.drawable.burger,"burger","180","234" ));
        list.add(new OrdersModel(R.drawable.biryani,"Biryani","200","114" ));
        list.add(new OrdersModel(R.drawable.fc,"French Fries","120","154" ));
        list.add(new OrdersModel(R.drawable.pizza,"pizza","200","424" ));
        list.add(new OrdersModel(R.drawable.burger,"burger","180","210" ));
        list.add(new OrdersModel(R.drawable.pizza,"pizza","200","524" ));

        OrdersAdapter adapter=new OrdersAdapter(list,this);
        binding.orderRecyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.orderRecyclerView.setLayoutManager(layoutManager);

        getSupportActionBar().setTitle("Order List!");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}