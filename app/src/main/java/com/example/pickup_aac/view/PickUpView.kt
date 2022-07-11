package com.example.pickup_aac.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.pickup_aac.R
import com.example.pickup_aac.viewModel.PickUpViewModel
import com.example.pickup_aac.databinding.PickUpViewBinding

class PickUpView : AppCompatActivity() {

    private lateinit var binding: PickUpViewBinding
    private val viewModel: PickUpViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.pick_up_view)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.setMaxNumbtn.setOnClickListener{
            val intent = Intent(this, SetMaxActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}