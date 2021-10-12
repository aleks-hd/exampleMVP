package com.hfad.examplemvp.model

class Data {
    val counters = mutableListOf(0, 0, 0)

    fun getCount(index: Int) = counters[index]

    fun next(index: Int): Int {
        counters[index]++
        return getCount(index)

    }

}

enum class Numb {
    ONE,
    TWO,
    THEE
}