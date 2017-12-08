package day08

import java.io.File
import java.io.FileNotFoundException

fun main(args: Array<String>) {

    val input = readFile("aoc2017/day08/input.txt")

    if (input == null) {
        println("Input file not found")
    } else {

        val output = input.map { it.split(" ") }.interpret()
        println(output)
    }
}

private fun List<List<String>>.interpret(): Int {

    val registers = mutableMapOf<String, Int>()
    var max = Int.MIN_VALUE

    this.forEach {

        val shouldModify = when (it[5]) {
            ">"  -> registers.getOrDefault(it[4], 0) > it[6].toInt()
            "<"  -> registers.getOrDefault(it[4], 0) < it[6].toInt()
            ">=" -> registers.getOrDefault(it[4], 0) >= it[6].toInt()
            "<=" -> registers.getOrDefault(it[4], 0) <= it[6].toInt()
            "==" -> registers.getOrDefault(it[4], 0) == it[6].toInt()
            "!=" -> registers.getOrDefault(it[4], 0) != it[6].toInt()
            else -> false
        }

        if (shouldModify) {

            val newValue = when (it[1]) {
                "inc" -> registers.getOrDefault(it[0], 0) + it[2].toInt()
                "dec" -> registers.getOrDefault(it[0], 0) - it[2].toInt()
                else  -> 0
            }

            registers.put(it[0], newValue)
            if (newValue > max) max = newValue
        }
    }

    return max
}

private fun readFile(pathname: String): List<String>? {

    return try {
        File(pathname /* aoc2017/dayXX/input.txt */).readLines()
    } catch (e: FileNotFoundException) {
        null
    }
}