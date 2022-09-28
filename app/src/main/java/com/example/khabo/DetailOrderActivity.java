package com.example.khabo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.khabo.databinding.ActivityDetailOrderBinding;

public class DetailOrderActivity extends AppCompatActivity {

    ActivityDetailOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        final int image=getIntent().getIntExtra("image",0);
        final int price= Integer.parseInt(getIntent().getStringExtra("price"));
        final String name=getIntent().getStringExtra("name");

        binding.detailOrderImage.setImageResource(image);
        binding.priceLabel.setText(String.format("%d",price));
        binding.foodName.setText(name);

        DBHelper helper=new DBHelper(this);

        binding.inserOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted=helper.insertOrder(
                        binding.nameBox.getText().toString(),
                        binding.phoneBox.getText().toString(),
                        price,
                        image,
                        name
                );
                if(isInserted)
                    Toast.makeText(DetailOrderActivity.this, "Data inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(DetailOrderActivity.this, "Data not inserted", Toast.LENGTH_SHORT).show();

            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return super.onSupportNavigateUp();
    }

}