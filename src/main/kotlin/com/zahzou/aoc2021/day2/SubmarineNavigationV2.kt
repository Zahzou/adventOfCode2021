package com.zahzou.aoc2021.day2

import com.zahzou.aoc2021.LineInput
import java.util.*

class SubmarineNavigationV2 :  LineInput("/day2/input.txt")  {
    fun getCoordinates(): Pair<Int, Int> =
            srcLines.map { it.split(" ") }
                    .map { Pair(it[0], it[1].toInt()) }
                    .let { calculateHeading(it.toMutableList()) }

    private fun calculateHeading(list : MutableList<Pair<String, Int>>, heading : Int = 0, depth : Int = 0, horizontal : Int = 0) : Pair<Int, Int>{
        if (list.isEmpty()) return Pair(depth, horizontal)
        val head = list.removeFirst()
        return when (head.first) {
            "down" -> calculateHeading(list, heading + head.second, depth, horizontal)
            "up" -> calculateHeading(list, heading - head.second, depth, horizontal)
            "forward" -> calculateHeading(list, heading, depth + (heading * head.second) , horizontal+ head.second)
            else -> throw InputMismatchException("Unknown command ${head.first}")
        }
    }
}

fun main() {
        val result = SubmarineNavigationV2().getCoordinates()
        println(result)
        println(result.first * result.second)
}