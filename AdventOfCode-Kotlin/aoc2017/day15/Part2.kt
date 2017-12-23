package day15

import java.io.File
import java.io.FileNotFoundException

fun main(args: Array<String>) {

    val input = readFile("aoc2017/day15/input.txt")

    if (input == null) {
        println("Input file not found")
    } else {
        val output = compareValues(
                generateValues(input[0].split(" ")[4].toLong(), 16807, 4),
                generateValues(input[1].split(" ")[4].toLong(), 48271, 8))
        println(output)
    }
}

private fun compareValues(valuesA: List<Long>, valuesB: List<Long>): Int {

    return valuesA
            .zip(valuesB)
            .count{ (a, b) -> a.toBinary(16).takeLast(16) == b.toBinary(16).takeLast(16) }
}

private fun generateValues(start: Long, factor: Long, multipleOf: Int): List<Long> {

    val values = mutableListOf<Long>()
    val max: Long = 2147483647
    var prev = start

    while (values.size < 5000000) {

        prev = (prev * factor) % max

        if (prev % multipleOf == 0L) {
            values.add(prev)
        }
    }

    return values
}

private fun Long.toBinary(length: Int): String = toString(2).padStart(length, '0')

private fun readFile(pathname: String): List<String>? {

    return try {
        File(pathname /* aoc2017/dayXX/input.txt */).readLines()
    } catch (e: FileNotFoundException) {
        null
    }
}