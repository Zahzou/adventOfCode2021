package com.zahzou.aoc2021.day3

import com.zahzou.aoc2021.LineInput

class LifeSupport : LineInput("/day3/input.txt") {
    private fun calculateMetric( lines : List<String>, comparison: (Int, Int) -> Boolean, index : Int = 0,): Int {
        val numberOfNumbers = lines.size
        val rawSums = lines.map { it.toCharArray().map { character -> character.code - 48 } }
                .reduce { a, b -> a.zip(b) { us, that -> us + that } }
        val significantString = rawSums.calculatePopularity(numberOfNumbers, comparison)
        val newList = lines.filter { significantString[index] == it[index] }
        return when (newList.size){
            1 ->  newList.also { println(it) }.first().toInt(2)
            else -> calculateMetric(newList, comparison,index+1)
        }
    }

    fun calculateOxygenGeneratorRating() : Int {
        return calculateMetric(srcLines,{a,b -> a >= b})
    }

    fun calculateCO2ScrubberRating() : Int {
        return calculateMetric(srcLines,{a,b -> a < b})
    }

    private fun List<Int>.calculatePopularity(lineCount : Int,  comparison: (Int, Int) -> Boolean ) : String =
            this.map { if (comparison(it, lineCount / 2)) 1 else 0 }
                    .joinToString("")

}


fun main() {
    val lifeSupport =  LifeSupport()
    println(lifeSupport.calculateOxygenGeneratorRating() * lifeSupport.calculateCO2ScrubberRating())
}