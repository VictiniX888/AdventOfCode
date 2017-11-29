package day00

import java.io.File
import java.io.FileNotFoundException

// https://pastebin.com/BMd61PUv

fun main(args: Array<String>) {

    val input = readFile("aoc2017/day00/input.txt")

    if (input == null) {
        println("Input file not found")
    } else {
        val (markerA, markerB) = markers(input.split(", "))
        val output = getFurthestDistance(markerA, markerB)

        println(output) //137
    }
}

private fun getFurthestDistance(pointsA: Set<Pair<Int, Int>>, pointsB: Set<Pair<Int, Int>>): Int {

    return pointsA.flatMap { p -> pointsB.map { getDistance(p, it) } }.max() ?: 0
}

private fun getDistance(pointA: Pair<Int, Int>, pointB: Pair<Int, Int>) = (pointA.first - pointB.first).abs() + (pointA.second - pointB.second).abs()

private fun markers(instructions: List<String>): Pair<Set<Pair<Int, Int>>, Set<Pair<Int, Int>>> {

    var x = 0
    var y = 0
    val markersA = mutableSetOf<Pair<Int, Int>>()
    val markersB = mutableSetOf<Pair<Int, Int>>()

    move@ for (s in instructions) {
        when(s) {
            "Right" -> x++
            "Left" -> x--
            "Up" -> y++
            "Down" -> y--
            "A" -> markersA.add(Pair(x, y))
            "B" -> markersB.add(Pair(x, y))
            "Start" -> break@move
        }
    }

    return Pair(markersA, markersB)
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