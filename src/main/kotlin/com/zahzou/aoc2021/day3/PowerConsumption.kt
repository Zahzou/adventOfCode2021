package com.zahzou.aoc2021.day3

import com.zahzou.aoc2021.LineInput

class PowerConsumption : LineInput("/day3/input.txt") {
    fun calculatePowerConsumption(): Int {
        val sourceLineCount = srcLines.size
        val rawSums = srcLines.map { it.toCharArray().map { character -> character.code - 48 } }
                .reduce { a, b -> a.zip(b) { us, that -> us + that } }
        val gammaRate = rawSums.calculatePopularity(sourceLineCount) { a, b -> a > b }
        val epsilonRate = rawSums.calculatePopularity(sourceLineCount) { a, b -> a < b }
        return epsilonRate * gammaRate
    }

    fun List<Int>.calculatePopularity(lineCount : Int, comparison: (Int, Int) -> Boolean) : Int =
            this.map { if (comparison(it, lineCount / 2)) 1 else 0 }
                    .joinToString("").also { println(it) }
                    .toInt(2).also { println(it) }

}


fun main() {
    println(PowerConsumption().calculatePowerConsumption())
}