package com.f1elle.prng.prng.data

fun generate(from: Int, to: Int, amount: Int, divider: String): String {
    val numbers = mutableListOf<Int>()
    for(i in (0 until amount)) {
        var number = (from..to).random()
        while (numbers.contains(number)) {
            number = (from..to).random()
        }
        numbers.add(number)
    }
    return numbers.joinToString(separator = divider)
}

fun generateWithReps(from: Int, to: Int, amount: Int, divider: String): String {
    val numbers = mutableListOf<Int>()
    for(i in (0 until amount)) {
        numbers.add((from..to).random())
    }
    return numbers.joinToString(separator = divider)
}