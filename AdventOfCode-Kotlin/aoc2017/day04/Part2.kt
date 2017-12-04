package day04

import java.io.File
import java.io.FileNotFoundException

fun main(args: Array<String>) {

    val input = readFile("aoc2017/day04/input.txt")

    if (input == null) {
        println("Input file not found")
    } else {
        val output = validPassphrases(input)
        println(output)
    }
}

private fun validPassphrases(passphrases: List<String>): Int {

    return passphrases
            .filter { !it.split(" ").hasAnagram() }
            .size
}

private fun List<String>.hasAnagram(): Boolean {

    val sortedList = this.map { it.toList().sorted() }

    return sortedList.toSet().toList() != sortedList
}

private fun readFile(pathname: String): List<String>? {

    return try {
        File(pathname /* aoc2017/dayXX/input.txt */).readLines()
    } catch (e: FileNotFoundException) {
        null
    }
}