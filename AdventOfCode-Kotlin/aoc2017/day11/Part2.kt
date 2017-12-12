package day11

import java.io.File
import java.io.FileNotFoundException
import kotlin.math.absoluteValue

fun main(args: Array<String>) {

    val input = readFile("aoc2017/day11/input.txt")

    if (input == null) {
        println("Input file not found")
    } else {
        val output = getFurthest(input.split(","))
        println(output)
    }
}

private fun getDistance(point: Point): Int = point.x.absoluteValue + ((point.y.absoluteValue - point.x.absoluteValue) / 2)

private fun getFurthest(path: List<String>): Int {

    val pos = Point(0, 0)

    return path
            .map {
        when (it) {
            "n"  -> {pos.move(Direction.NORTH); getDistance(pos.copy())}
            "ne" -> {pos.move(Direction.NORTHEAST); getDistance(pos.copy())}
            "se" -> {pos.move(Direction.SOUTHEAST); getDistance(pos.copy())}
            "s"  -> {pos.move(Direction.SOUTH); getDistance(pos.copy())}
            "sw" -> {pos.move(Direction.SOUTHWEST); getDistance(pos.copy())}
            "nw" -> {pos.move(Direction.NORTHWEST); getDistance(pos.copy())}
            else -> 0
        }
    }
            .max() ?: 0

}

private fun readFile(pathname: String): String? {

    return try {
        File(pathname /* aoc2017/dayXX/input.txt */).readText()
    } catch (e: FileNotFoundException) {
        null
    }
}