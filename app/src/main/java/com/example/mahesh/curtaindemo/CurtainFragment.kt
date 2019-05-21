package com.example.mahesh.curtaindemo


import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.constraint.motion.MotionLayout
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mahesh.curtaindemo.databinding.FragmentCurtainBinding


class CurtainFragment : Fragment() {

    interface ParentView {
        fun root(): View
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        parentView = activity as ParentView
    }

    private lateinit var parentView: ParentView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentCurtainBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_curtain, container, false)


        val adapter = RvAdapter(context!!)
        binding.rvList.layoutManager = LinearLayoutManager(context)
        binding.rvList.adapter = adapter


        binding.clBack.setDebugMode(MotionLayout.DEBUG_SHOW_PATH)
//        binding.clBack.bringChildToFront(parentView.root())

        return binding.root
    }

}
