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
            .filter { !it.split(" ").hasRepeat() }
            .size
}

private fun <E> List<E>.hasRepeat(): Boolean {

    return this.toSet().toList() != this
}

private fun readFile(pathname: String): List<String>? {

    return try {
        File(pathname /* aoc2017/dayXX/input.txt */).readLines()
    } catch (e: FileNotFoundException) {
        null
    }
}