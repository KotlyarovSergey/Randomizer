package com.ksv.randomizer.numbers

data class NumbersSettingSet(
    val range: IntRange,
    val quantity: Int,
    val linear: Boolean,
    val shuffle: Boolean
)
