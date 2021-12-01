package com.zahzou.aoc2021.day1

class SonarDetector {

    private val srcLines = SonarDetector::class.java.getResourceAsStream("/day1/sonarInput.txt").bufferedReader().readLines()
    fun getIncreases(): Int =
            srcLines.map { it.toInt() }.zipWithNext { a, b -> b - a }.count { it > 0 }

}

fun main() {
    println(SonarDetector().getIncreases())
}