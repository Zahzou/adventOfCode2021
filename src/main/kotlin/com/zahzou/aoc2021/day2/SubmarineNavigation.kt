package com.zahzou.aoc2021.day2

import com.zahzou.aoc2021.LineInput
import java.util.*

open class SubmarineNavigation() : LineInput("/day2/input.txt") {


    fun getCoordinates(): Pair<Int, Int> =
            srcLines.map { it.split(" ") }
                    .map { Pair(it[0], it[1].toInt()) }
                    .let { calculateCoordinates(it.toMutableList()) }


    private fun calculateCoordinates(list : MutableList<Pair<String, Int>>, depth : Int = 0, horizontal : Int = 0) : Pair<Int, Int>{
        if (list.isEmpty()) return Pair(depth, horizontal)
        val head = list.removeFirst()
        return when (head.first) {
            "down" -> calculateCoordinates(list, depth + head.second, horizontal)
            "up" -> calculateCoordinates(list, depth - head.second, horizontal)
            "forward" -> calculateCoordinates(list, depth , horizontal+ head.second)
            else -> throw InputMismatchException("Unknown command ${head.first}")
        }
    }

}

fun main() {
        val result = SubmarineNavigation().getCoordinates()
        println(result)
        println(result.first * result.second)
}