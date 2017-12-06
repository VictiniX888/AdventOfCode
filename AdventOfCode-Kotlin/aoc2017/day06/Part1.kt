package day06

import java.io.File
import java.io.FileNotFoundException

fun main(args: Array<String>) {

    val input = readFile("aoc2017/day06/input.txt")

    if (input == null) {
        println("Input file not found")
    } else {
        val output = getCycles(input.split("\t").map { it.toInt() })
        println(output)
    }
}

private fun getCycles(input: List<Int>): Int {

    val banks = input.toMutableList()
    val configs = mutableListOf<List<Int>>()
    val size = banks.size
    var count = 0

    do {
        configs.add(banks.toList())
        count++

        val max = banks.max()
        if (max == null) {
            println("Parsing error"); return -1
        }
        val maxBank = banks.indexOf(max)
        banks[maxBank] = 0
        for (i in 1 .. max) {
            banks[(i + maxBank) % size]++
        }
    } while (!configs.contains(banks))

    return count
}

private fun readFile(pathname: String): String? {

    return try {
        File(pathname /* aoc2017/dayXX/input.txt */).readText()
    } catch (e: FileNotFoundException) {
        null
    }
}