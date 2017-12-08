package day08

import java.io.File
import java.io.FileNotFoundException

fun main(args: Array<String>) {

    val input = readFile("aoc2017/day08/input.txt")

    if (input == null) {
        println("Input file not found")
    } else {

        val output = input.map { it.split(" ") }.interpret().maxBy { (_, i) -> i }
        println(output)
    }
}

private fun List<List<String>>.interpret(): Map<String, Int> {

    val registers = mutableMapOf<String, Int>()

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
        }
    }

    return registers
}

private fun readFile(pathname: String): List<String>? {

    return try {
        File(pathname /* aoc2017/dayXX/input.txt */).readLines()
    } catch (e: FileNotFoundException) {
        null
    }
}