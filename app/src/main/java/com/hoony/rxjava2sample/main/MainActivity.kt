package com.hoony.rxjava2sample.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.hoony.rxjava2sample.R
import com.hoony.rxjava2sample.databinding.ActivityMainBinding
import com.hoony.rxjava2sample.sample1.Sample1Activity

class MainActivity : AppCompatActivity(), MainListAdapter.MainListListener {

    private lateinit var binding: ActivityMainBinding
    private val sampleList = listOf(
        Sample(
            "Sample 1",
            Sample1Activity::class.java
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )

        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.mainList.apply {
            layoutManager = LinearLayoutManager(
                this@MainActivity,
                LinearLayoutManager.VERTICAL,
                false
            )
            addItemDecoration(
                DividerItemDecoration(
                    this@MainActivity,
                    DividerItemDecoration.VERTICAL
                )
            )
            adapter = MainListAdapter(this@MainActivity).apply {
                submitList(sampleList)
            }
        }
    }

    private fun startActivity(sample: Sample) {
        startActivity(Intent(this, sample.targetActivity))
    }

    override fun onItemClick(position: Int) {
        startActivity(sampleList[position])
    }
}