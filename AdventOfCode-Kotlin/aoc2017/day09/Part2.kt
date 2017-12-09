package day09

import java.io.File
import java.io.FileNotFoundException

fun main(args: Array<String>) {

    val input = readFile("aoc2017/day09/input.txt")

    if (input == null) {
        println("Input file not found")
    } else {

        val output = getGarbage(input)
        println(output)
    }
}

private fun getGarbage(stream: String): Int {

    var count = 0
    var isGarbage = false

    stream.replace(Regex("!."), "").forEach {

        when (it) {
            '<' -> if(isGarbage) count++ else isGarbage = true
            '>' -> isGarbage = false
            else -> if(isGarbage) count++
        }
    }

    return count
}

private fun readFile(pathname: String): String? {

    return try {
        File(pathname /* aoc2017/dayXX/input.txt */).readText()
    } catch (e: FileNotFoundException) {
        null
    }
}