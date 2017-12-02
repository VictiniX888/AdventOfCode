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

    return list.fold(0, { acc, it -> acc + getDivision(it) })
}

private fun getDivision(list: List<Int>): Int {

    val sortedList = list.sortedDescending()

    for (i in 0 until sortedList.size) {
        for (j in i+1 until sortedList.size) {
            if (sortedList[i].canDivide(sortedList[j])) {
                return sortedList[i] / sortedList[j]
            }
        }
    }

    return 0
}

private fun Int.canDivide(divisor: Int): Boolean = this % divisor == 0

private fun readFile(pathname: String): List<String>? {

    return try {
        File(pathname /* aoc2017/dayXX/input.txt */).readLines()
    } catch (e: FileNotFoundException) {
        null
    }
}