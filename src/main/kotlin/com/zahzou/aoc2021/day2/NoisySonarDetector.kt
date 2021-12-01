package com.zahzou.aoc2021.day2


class NoisySonarDetector {

    private val srcLines = NoisySonarDetector::class.java.getResourceAsStream("/day2/input.txt").bufferedReader().readLines()
    fun getIncreases(): Int =
            srcLines.asSequence().map { it.toInt() }.windowed(3,1).map { it.sum() }.zipWithNext { a, b -> b - a }.count { it > 0 }

}

fun main() {
    println(NoisySonarDetector().getIncreases())
}