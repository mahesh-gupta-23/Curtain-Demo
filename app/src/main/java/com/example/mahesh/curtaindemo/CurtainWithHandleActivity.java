package com.example.mahesh.curtaindemo;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.mahesh.curtaindemo.databinding.ActivityCurtainWithBinding;

public class CurtainWithHandleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCurtainWithBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_curtain_with);

        RvAdapter adapter = new RvAdapter(this);
        binding.rvList.setLayoutManager(new LinearLayoutManager(this));
        binding.rvList.setAdapter(adapter);
    }
}
