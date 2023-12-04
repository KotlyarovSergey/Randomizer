package com.ksv.randomizer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.ksv.randomizer.databinding.ActivityNumbersBinding

class ActivityNumbers : AppCompatActivity() {
    private lateinit var binding: ActivityNumbersBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNumbersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.i("ksvlog", "activity NUMBERS created")
    }

    fun onClickGenerate(view: View){
//        Log.i("ksvlog", "onClick if worked")

        if (binding.etRangeStart.text.isEmpty())
            binding.etRangeStart.setText("0")

        if(binding.etRangeEnd.text.isEmpty())
            binding.etRangeEnd.setText("0")

        var start = binding.etRangeStart.text.toString().toInt()
        var end = binding.etRangeEnd.text.toString().toInt()

        if(start > end){
            val tmpInt = end
            end = start
            start = tmpInt
        }

        val result = (start..end).random()
        Log.i("ksvlog", "start: $start, end: $end, rand: $result")
        binding.tvResult.text = result.toString()
    }
}