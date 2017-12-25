package day17

import java.io.File
import java.io.FileNotFoundException

fun main(args: Array<String>) {

    val input = readFile("aoc2017/day17/input.txt")

    if (input == null) {
        println("Input file not found")
    } else {
        val spinlock = spinlock(input.toInt())
        val output = spinlock[spinlock.indexOf(2017) + 1]
        println(output)
    }
}

private fun spinlock(steps: Int): List<Int> {

    val buffer = mutableListOf(0)
    var pos = 0

    (1 .. 2017).forEach {
        pos = ((pos + steps) % it) + 1
        buffer.add(pos, it)
    }

    return buffer
}

private fun readFile(pathname: String): String? {

    return try {
        File(pathname /* aoc2017/dayXX/input.txt */).readText()
    } catch (e: FileNotFoundException) {
        null
    }
}