package com.example.mahesh.curtaindemo;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.example.mahesh.curtaindemo.databinding.ActivitySlidingDrawerLibSampleBinding;

public class SlidingDrawerLibSampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySlidingDrawerLibSampleBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_sliding_drawer_lib_sample);

        RvAdapter adapter = new RvAdapter(this);
        binding.rvList.setLayoutManager(new LinearLayoutManager(this));
        binding.rvList.setAdapter(adapter);

//        binding.rvList.scrollToPosition(9);

        binding.tvDummy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SlidingDrawerLibSampleActivity.this, "Clicked", Toast.LENGTH_LONG).show();
            }
        });
    }
}
