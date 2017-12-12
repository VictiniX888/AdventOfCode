package day11

import java.io.File
import java.io.FileNotFoundException
import kotlin.math.absoluteValue

fun main(args: Array<String>) {

    val input = readFile("aoc2017/day11/input.txt")

    if (input == null) {
        println("Input file not found")
    } else {
        val output = getDistance(getPos(input.split(",")))
        println(output)
    }
}

private fun getDistance(point: Point): Int = point.x.absoluteValue + ((point.y.absoluteValue - point.x.absoluteValue) / 2)

private fun getPos(path: List<String>): Point {

    val pos = Point(0, 0)

    path.forEach {
        when (it) {
            "n"  -> pos.move(Direction.NORTH)
            "ne" -> pos.move(Direction.NORTHEAST)
            "se" -> pos.move(Direction.SOUTHEAST)
            "s"  -> pos.move(Direction.SOUTH)
            "sw" -> pos.move(Direction.SOUTHWEST)
            "nw" -> pos.move(Direction.NORTHWEST)
        }
    }

    return pos
}

private fun readFile(pathname: String): String? {

    return try {
        File(pathname /* aoc2017/dayXX/input.txt */).readText()
    } catch (e: FileNotFoundException) {
        null
    }
}