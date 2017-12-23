package day15

import java.io.File
import java.io.FileNotFoundException

fun main(args: Array<String>) {

    val input = readFile("aoc2017/day15/input.txt")

    if (input == null) {
        println("Input file not found")
    } else {
        val output = generateValues(input[0].split(" ")[4].toLong(), input[1].split(" ")[4].toLong())
        println(output)
    }
}

private fun generateValues(startA: Long, startB: Long): Int {

    val max: Long = 2147483647
    val factorA: Long = 16807
    val factorB: Long = 48271
    var prevA: Long = startA
    var prevB: Long = startB
    var count = 0

    (0 until 40000000).forEach {
        prevA = (prevA * factorA) % max
        prevB = (prevB * factorB) % max

        if (prevA.toBinary(16).takeLast(16) == prevB.toBinary(16).takeLast(16)) {
            count++
        }
    }

    return count
}

private fun Long.toBinary(length: Int): String = toString(2).padStart(length, '0')

private fun readFile(pathname: String): List<String>? {

    return try {
        File(pathname /* aoc2017/dayXX/input.txt */).readLines()
    } catch (e: FileNotFoundException) {
        null
    }
}