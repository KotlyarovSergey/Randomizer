package com.ksv.randomizer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.ksv.randomizer.databinding.ActivityNumbersBinding
import com.ksv.randomizer.numbers.NumbersGenerator
import com.ksv.randomizer.numbers.NumbersSettingSet

class ActivityNumbers : AppCompatActivity() {
    private lateinit var binding: ActivityNumbersBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNumbersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.switchLinear.setOnCheckedChangeListener(this::onCheckedChangeLinear)
        binding.switchShuffle.setOnCheckedChangeListener(this::onCheckedChangeShuffle)

        Log.i("ksvlog", "activity NUMBERS created")
    }


    fun onClickGenerate(view: View) {
//        Log.i("ksvlog", "onClick if worked")

        checkAndFixWrongInput()

        val settingSet = getSettings()

        val numbersGenerator = NumbersGenerator(settingSet)
        val randomNumbers = numbersGenerator.generate()

        val result = randomNumbers.joinToString(", ")
        binding.tvResult.text = result
    }

    private fun onCheckedChangeLinear(buttonView: View, isChecked: Boolean) {
        val switchLinearText: String
        when (isChecked) {
            true -> {
                switchLinearText = getText(R.string.switch_linear_yes).toString()
                binding.switchShuffle.isEnabled = true
            }
            else -> {
                switchLinearText = getText(R.string.switch_linear_no).toString()
                binding.switchShuffle.isChecked = false
                binding.switchShuffle.isEnabled = false
            }
        }
        binding.switchLinear.text = switchLinearText
    }

    private fun onCheckedChangeShuffle(view: View, isChecked: Boolean) {
        binding.switchShuffle.text = when (isChecked) {
            true -> getText(R.string.switch_shuffle_yes)
            else -> getText(R.string.switch_shuffle_no)
        }
    }


    private fun checkAndFixWrongInput() {

        if (binding.etRangeStart.text.isEmpty())
            binding.etRangeStart.setText("0")

        if (binding.etRangeEnd.text.isEmpty())
            binding.etRangeEnd.setText(getString(R.string.et_range_end_hint))

        if (binding.etQuantityNumbers.text.isEmpty() ||
            binding.etQuantityNumbers.text.toString() == "0"
        )
            binding.etQuantityNumbers.setText("1")

    }

    private fun getSettings(): NumbersSettingSet {
        val start = binding.etRangeStart.text.toString().toInt()
        val end = binding.etRangeEnd.text.toString().toInt()
        val range = getCorrectRange(start, end)

        val quantityNumbers = binding.etQuantityNumbers.text.toString().toInt()

        val random = binding.switchLinear.isChecked
        val shuffle = binding.switchShuffle.isChecked

        return NumbersSettingSet(range, quantityNumbers, random, shuffle)
    }

    private fun getCorrectRange(value1: Int, value2: Int): IntRange {
        if (value1 <= value2) {
            return value1..value2
        }
        return value2..value1
    }
}