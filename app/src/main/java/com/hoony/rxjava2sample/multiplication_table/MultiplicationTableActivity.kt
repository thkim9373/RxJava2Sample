package com.hoony.rxjava2sample.multiplication_table

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.hoony.rxjava2sample.R
import com.hoony.rxjava2sample.databinding.ActivityMultiplicationTableBinding

class MultiplicationTableActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMultiplicationTableBinding
    private val viewModel by viewModels<MultiplicationTableViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_multiplication_table)
    }
}