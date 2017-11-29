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
        val origin = Point(0, 0)

        val output = getFurthestDistance(markers, origin)

        println(output) //86
    }
}

private fun getFurthestDistance(markers: Set<Point>, compareWith: Point): Int {

    return markers.map { getDistance(it, compareWith) }.max() ?: 0
}

private fun getDistance(pointA: Point, pointB: Point) = (pointA.x - pointB.x).abs() + (pointA.y - pointB.y).abs()

private fun markers(instructions: List<String>): Set<Point> {

    val coord = Point(0, 0)
    val markers = mutableSetOf<Point>()

    move@ for (s in instructions) {
        when(s) {
            "Right"  -> coord.move(Direction.RIGHT)
            "Left"   -> coord.move(Direction.LEFT)
            "Up"     -> coord.move(Direction.UP)
            "Down"   -> coord.move(Direction.DOWN)
            "A", "B" -> markers.add(coord.copy())
            "Start"  -> break@move
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