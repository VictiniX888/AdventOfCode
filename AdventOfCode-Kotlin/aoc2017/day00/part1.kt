package day00

import java.io.File
import java.io.FileNotFoundException

// https://pastebin.com/BMd61PUv

fun main(args: Array<String>) {

    val input = readFile("aoc2017/day00/input.txt")

    if(input == null) {
        println("Input file not found")
    } else {

        val markers = markers(input.split(", "))
        val origin = Pair(0, 0)

        val output = getFurthestDistance(markers, origin)

        println(output) //86
    }
}

private fun getFurthestDistance(markers: Set<Pair<Int, Int>>, compareWith: Pair<Int, Int>): Int {

    return markers.map { getDistance(it, compareWith) }.max() ?: 0
}

private fun getDistance(pointA: Pair<Int, Int>, pointB: Pair<Int, Int>) = (pointA.first - pointB.first).abs() + (pointA.second - pointB.second).abs()

private fun markers(instructions: List<String>): Set<Pair<Int, Int>> {

    var x = 0
    var y = 0
    val markers = mutableSetOf<Pair<Int, Int>>()

    move@ for (s in instructions) {
        when(s) {
            "Right" -> x++
            "Left" -> x--
            "Up" -> y++
            "Down" -> y--
            "A", "B" -> markers.add(Pair(x, y))
            "Start" -> break@move
        }
    }

    return markers
}

/////////////////////////////////
// useful functions
/////////////////////////////////

private fun readFile(pathname: String): String? {

    return try {
        File(pathname /* aoc2017/dayXX/input.txt */).readText()
    } catch (e: FileNotFoundException) {
        null
    }
}

private fun Int.abs(): Int {    //absolute value function

    return when {
        this < 0 -> this * -1
        else     -> this
    }
}