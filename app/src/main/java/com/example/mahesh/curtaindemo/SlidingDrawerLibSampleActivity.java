package com.example.mahesh.curtaindemo;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.example.mahesh.curtaindemo.databinding.ActivitySlidingDrawerLibSampleBinding;

public class SlidingDrawerLibSampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySlidingDrawerLibSampleBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_sliding_drawer_lib_sample);

        RvAdapter adapter = new RvAdapter(this);
        binding.rvList.setLayoutManager(new LinearLayoutManager(this));
        binding.rvList.setAdapter(adapter);
    }
}
