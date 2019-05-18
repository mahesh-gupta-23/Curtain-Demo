package com.example.mahesh.curtaindemo

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager

class CurtainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: com.example.mahesh.curtaindemo.databinding.ActivityCurtainBinding = DataBindingUtil.setContentView(this, R.layout.activity_curtain)

        val adapter = RvAdapter(this)
        binding.rvList.setLayoutManager(LinearLayoutManager(this))
        binding.rvList.setAdapter(adapter)
    }
}
