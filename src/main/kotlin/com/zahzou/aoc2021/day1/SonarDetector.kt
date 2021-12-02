package com.zahzou.aoc2021.day1

import com.zahzou.aoc2021.LineInput

class SonarDetector : LineInput("/day1/sonarInput.txt") {

    fun getIncreases(): Int =
            srcLines.map { it.toInt() }.zipWithNext { a, b -> b - a }.count { it > 0 }

}

fun main() {
    println(SonarDetector().getIncreases())
}