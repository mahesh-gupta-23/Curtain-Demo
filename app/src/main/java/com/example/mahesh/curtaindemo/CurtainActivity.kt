package com.example.mahesh.curtaindemo

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.text.TextUtils.replace
import android.view.View
import android.widget.Toast
import com.example.mahesh.curtaindemo.databinding.ActivityCurtainBinding

class CurtainActivity : AppCompatActivity(), CurtainFragment.ParentView {

    override fun root(): View = binding.clBack


    private lateinit var binding: ActivityCurtainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_curtain)

        binding.btnClick.setOnClickListener {
            Toast.makeText(this, "Button Clicked", Toast.LENGTH_LONG).show()
        }

        supportFragmentManager.beginTransaction().apply {
            replace(android.R.id.content, CurtainFragment())
        }.commit()
    }
}
