package com.ksv.randomizer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ksv.randomizer.databinding.ActivityNumbersBinding

class ActivityNumbers : AppCompatActivity() {
    private lateinit var binding: ActivityNumbersBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNumbersBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}