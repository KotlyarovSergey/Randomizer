package com.ksv.randomizer.numbers

class NumbersGenerator(private val settingSet: NumbersSettingSet) {
    fun generate(): List<Int> {
        if (settingSet.quantity == 1)
            return listOf(onceGeneration())

        val resultList: List<Int> = if (settingSet.linear)
            linearGeneration()
        else
            simpleGeneration()

        if (settingSet.shuffle)
            return resultList.shuffled()

        return resultList
    }

    private fun onceGeneration(): Int {
        return settingSet.range.random()
    }

    private fun simpleGeneration(): List<Int> {
        val result = mutableListOf<Int>()
        repeat(settingSet.quantity) {
            result.add(settingSet.range.random())
        }
        return result
    }

    private fun linearGeneration(): List<Int> {
        val result = mutableListOf<Int>()

        val min = settingSet.range.min()
        val max = settingSet.range.max()
        val delta = (max - min) / settingSet.quantity.toDouble()

        for (i in 0 until settingSet.quantity) {
            val start = (i * delta).toInt() + min
            val end = ((i + 1) * delta).toInt() + min
            val number = (start..end).random()
            result.add(number)
        }

        return result
    }
}