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

        var start = 0
        var tmpString = binding.etRangeStart.text.toString()

        if (!tmpString.isEmpty()){
            start = tmpString.toInt()
        }

        var end = 0
        tmpString = binding.etRangeEnd.text.toString()
        if(!tmpString.isEmpty()){
            end = tmpString.toInt()
        }

        if(start > end){
            var tmpInt = end
            end = start
            start = tmpInt
        }

        val result = (start..end).random()
        Log.i("ksvlog", "start: $start, end: $end, rand: $result")
        binding.tvResult.text = result.toString()
    }
}