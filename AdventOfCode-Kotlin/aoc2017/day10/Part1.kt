package day10

import java.io.File
import java.io.FileNotFoundException

fun main(args: Array<String>) {

    val input = readFile("aoc2017/day10/input.txt")

    if (input == null) {
        println("Input file not found")
    } else {

        val output = hash(input.split(",").map { it.toInt() }).take(2).reduce { acc, i -> acc * i }
        println(output)
    }
}

private fun hash(lengths: List<Int>): List<Int> {

    val circle = (0..255).toMutableList()
    var skip = 0
    var pos = 0

    lengths.forEach { length ->

        val reversed: List<Int>

        if (pos + length > circle.size) {
            reversed = circle.toMutableList().subList(pos, circle.size)
            reversed.addAll(circle.toList().subList(0, (pos + length) % circle.size))
            reversed.reverse()
        } else {
            reversed = circle.toList().subList(pos, pos + length).reversed()
        }

        (pos .. pos + length - 1).forEach { circle[it % circle.size] = reversed[it - pos] }
        pos = (pos + length + skip) % circle.size
        skip++
    }

    return circle
}

private fun readFile(pathname: String): String? {

    return try {
        File(pathname /* aoc2017/dayXX/input.txt */).readText()
    } catch (e: FileNotFoundException) {
        null
    }
}