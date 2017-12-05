package day05

import java.io.File
import java.io.FileNotFoundException

fun main(args: Array<String>) {

    val input = readFile("aoc2017/day05/input.txt")

    if (input == null) {
        println("Input file not found")
    } else {
        val output = getSteps(input.map { it.toInt() })
        println(output)
    }
}

private fun getSteps(input: List<Int>): Int {

    val jumps = input.toMutableList()
    var pos = 0
    var count = 0

    while (pos < jumps.size) {
        jumps[pos]++
        pos += jumps[pos] - 1   // because I don't want to make a temp variable
        count++
    }

    return count
}

private fun readFile(pathname: String): List<String>? {

    return try {
        File(pathname /* aoc2017/dayXX/input.txt */).readLines()
    } catch (e: FileNotFoundException) {
        null
    }
}