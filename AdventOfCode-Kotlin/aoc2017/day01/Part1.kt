package day01

import java.io.File
import java.io.FileNotFoundException

fun main(args: Array<String>) {

    val input = readFile("aoc2017/day01/input.txt")

    if (input == null) {
        println("Input file not found")
    } else {
        val output = getSum(input)
        println(output)
    }
}

private fun getSum(digits: String): Int {

    return digits
            .mapIndexed { index, c -> if (c.toInt() == digits[(index+1)%digits.length].toInt()) c.toInt() - 48 else 0 }
            .sum()
}

private fun readFile(pathname: String): String? {

    return try {
        File(pathname /* aoc2017/dayXX/input.txt */).readText()
    } catch (e: FileNotFoundException) {
        null
    }
}