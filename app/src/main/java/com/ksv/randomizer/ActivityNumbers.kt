package com.ksv.randomizer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.ksv.randomizer.databinding.ActivityNumbersBinding
import com.ksv.randomizer.numbers.NumbersSettingSet

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

        checkedInput()

        val settingSet = getSettings()

        val randoms = getRandoms(settingSet)


//        Log.i("ksvlog", "start: ${settingSet.start}, end: ${settingSet.end}, quantity: ${settingSet.quantity}")
        Log.i("ksvlog", "range: ${settingSet.range}, quantity: ${settingSet.quantity}")
        Log.i("ksvlog", "result: $randoms")

        val result = randoms.joinToString(", ")
        binding.tvResult.text = result
    }



    private fun getRandoms(settingSet: NumbersSettingSet): List<Int>{
        val numbers = mutableListOf<Int>()
        repeat(settingSet.quantity){
            numbers.add(settingSet.range.random())
        }
        return numbers
    }

    private fun checkedInput(){

        if (binding.etRangeStart.text.isEmpty())
            binding.etRangeStart.setText("0")

        if(binding.etRangeEnd.text.isEmpty())
            binding.etRangeEnd.setText("0")

        if(binding.etQuantityNumbers.text.isEmpty())
            binding.etQuantityNumbers.setText("1")

    }

    private fun getSettings(): NumbersSettingSet{
        var start = binding.etRangeStart.text.toString().toInt()
        var end = binding.etRangeEnd.text.toString().toInt()

        if(start > end){
            val tmpInt = end
            end = start
            start = tmpInt
        }

        var quantityNumbers = binding.etQuantityNumbers.text.toString().toInt()
        if(quantityNumbers == 0) {
            quantityNumbers = 1
            binding.etQuantityNumbers.setText("1")
        }

        return NumbersSettingSet(start..end, quantityNumbers)

    }
}