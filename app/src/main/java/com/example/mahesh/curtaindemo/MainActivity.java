package com.example.mahesh.curtaindemo;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.mahesh.curtaindemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    TopSheetBehavior<RelativeLayout> topSheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        topSheet = TopSheetBehavior.from(binding.llCurtain);
        topSheet.setTopSheetCallback(new TopSheetBehavior.TopSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                Log.d("mp-TAG", "onStateChanged: " + newState);
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset, @Nullable Boolean isOpening) {
                Log.d("mp-TAG", "onSlide: slideOffset " + slideOffset);
                Log.d("mp-TAG", "onSlide: isOpening " + isOpening);
            }
        });

        RvAdapter adapter = new RvAdapter(this);
        binding.rvList.setLayoutManager(new LinearLayoutManager(this));
        binding.rvList.setAdapter(adapter);

        binding.clMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                topSheet.setState(TopSheetBehavior.STATE_COLLAPSED);
            }
        });
    }
}
