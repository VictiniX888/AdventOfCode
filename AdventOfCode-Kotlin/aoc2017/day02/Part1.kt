package day02

import java.io.File
import java.io.FileNotFoundException

fun main(args: Array<String>) {

    val input = readFile("aoc2017/day02/input.txt")

    if (input == null) {
        println("Input file not found")
    } else {
        val output = getSumOfDiffs( input.map { it.split("\t").map { it.toInt() } } )
        println(output)
    }
}

private fun getSumOfDiffs(list: List<List<Int>>): Int {

    return list.fold(0, { acc, it -> acc + getDifference(it) })
}

private fun getDifference(ns: List<Int>): Int {

    val sortedList = ns.sorted()
    return sortedList.last() - sortedList.first()
}

private fun readFile(pathname: String): List<String>? {

    return try {
        File(pathname /* aoc2017/dayXX/input.txt */).readLines()
    } catch (e: FileNotFoundException) {
        null
    }
}