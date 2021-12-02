package com.zahzou.aoc2021

import com.zahzou.aoc2021.day2.SubmarineNavigation

open class LineInput(value: String) {
    protected val srcLines = SubmarineNavigation::class.java.getResourceAsStream(value).bufferedReader().readLines()
}
