package day13

import java.io.File
import java.io.FileNotFoundException

fun main(args: Array<String>) {

    val input = readFile("aoc2017/day13/input.txt")

    if (input == null) {
        println("Input file not found")
    } else {
        val output = findDelay(initWall(input.map { it.split(": ").map { i -> i.toInt() } }))
        println(output)
    }
}

private fun findDelay(wall: List<Pair<Int, Int>>): Int {

    var delay = 0

    while (true) {

        delay++
        if (!isCaught(delay, wall)) return delay
    }
}

private fun isCaught(delay: Int, wall: List<Pair<Int, Int>>): Boolean {

    wall.forEach { (first, second) -> if ((first + delay) % (second - 1) == 0 && ((first + delay) / (second - 1)) % 2 == 0) return true }

    return false
}

private fun initWall(input: List<List<Int>>): List<Pair<Int, Int>> {

    return input.map { Pair(it[0], it[1]) }
}

private fun readFile(pathname: String): List<String>? {

    return try {
        File(pathname /* aoc2017/dayXX/input.txt */).readLines()
    } catch (e: FileNotFoundException) {
        null
    }
}