package com.example.pickup_aac.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.pickup_aac.R
import com.example.pickup_aac.viewModel.PickUpViewModel
import com.example.pickup_aac.databinding.SetMaxBinding

class SetMaxActivity : AppCompatActivity() {
    private lateinit var bind : SetMaxBinding
    private val model: PickUpViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = DataBindingUtil.setContentView(this, R.layout.set_max)

        bind.lifecycleOwner = this
        bind.viewmodelSetMaxNum = PickUpViewModel()

        bind.complete.setOnClickListener {
            model.setMaxNum(Integer.parseInt(bind.maxnum.text.toString()))
            val intent = Intent(this, PickUpView::class.java)
            startActivity(intent)
            finish()
        }
    }
}