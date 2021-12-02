package com.zahzou.aoc2021.day1

import com.zahzou.aoc2021.LineInput


class NoisySonarDetector : LineInput("/day1/noisySonarInput.txt") {

    fun getIncreases(): Int =
            srcLines.asSequence().map { it.toInt() }.windowed(3,1).map { it.sum() }.zipWithNext { a, b -> b - a }.count { it > 0 }

}

fun main() {
    println(NoisySonarDetector().getIncreases())
}