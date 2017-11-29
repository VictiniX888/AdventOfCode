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

private fun getFurthestDistance(pointsA: Set<Point>, pointsB: Set<Point>): Int {

    return pointsA.flatMap { p -> pointsB.map { getDistance(p, it) } }.max() ?: 0
}

private fun getDistance(pointA: Point, pointB: Point) = (pointA.x - pointB.x).abs() + (pointA.y - pointB.y).abs()

private fun markers(instructions: List<String>): Pair<Set<Point>, Set<Point>> {

    val coord = Point(0, 0)
    val markersA = mutableSetOf<Point>()
    val markersB = mutableSetOf<Point>()

    move@ for (s in instructions) {
        when(s) {
            "Right"  -> coord.move(Direction.RIGHT)
            "Left"   -> coord.move(Direction.LEFT)
            "Up"     -> coord.move(Direction.UP)
            "Down"   -> coord.move(Direction.DOWN)
            "A"      -> markersA.add(coord.copy())
            "B"      -> markersB.add(coord.copy())
            "Start"  -> break@move
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