package day17

import java.io.File
import java.io.FileNotFoundException

fun main(args: Array<String>) {

    val input = readFile("aoc2017/day17/input.txt")

    if (input == null) {
        println("Input file not found")
    } else {
        val output = spinlock(input.toInt())
        println(output)
    }
}

private fun spinlock(steps: Int): Int {

    var index1 = 1
    var pos = 1

    (2 .. 50_000_000).forEach {
        pos = ((pos + steps) % it) + 1
        if(pos == 1) index1 = it
    }

    return index1
}

private fun readFile(pathname: String): String? {

    return try {
        File(pathname /* aoc2017/dayXX/input.txt */).readText()
    } catch (e: FileNotFoundException) {
        null
    }
}