package day09

import java.io.File
import java.io.FileNotFoundException

fun main(args: Array<String>) {

    val input = readFile("aoc2017/day09/input.txt")

    if (input == null) {
        println("Input file not found")
    } else {

        val output = getScore(input)
        println(output)
    }
}

private fun getScore(stream: String): Int {

    var score = 0
    var bracketLevel = 0
    var isGarbage = false

    stream.replace(Regex("!."), "").forEach {

        if (!isGarbage) {

            when (it) {
                '{' -> { bracketLevel++; score += bracketLevel }
                '}' -> bracketLevel--
                '<' -> isGarbage = true
            }
        } else if (it == '>') {

            isGarbage = false
        }
    }

    return score
}

private fun readFile(pathname: String): String? {

    return try {
        File(pathname /* aoc2017/dayXX/input.txt */).readText()
    } catch (e: FileNotFoundException) {
        null
    }
}