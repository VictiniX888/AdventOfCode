package day21

import java.io.File
import java.io.FileNotFoundException
import kotlin.math.roundToInt
import kotlin.math.sqrt

fun main(args: Array<String>) {

    val input = readFile("aoc2017/day21/input.txt")

    if (input == null) {
        println("Input file not found")
    } else {

        val rules = parseInput(input)
        val square = ".#./..#/###".toSquare()
        val output = iterate(square, 18, rules)
        println(output)
    }
}

private fun iterate(square: Square, iterations: Int, rules: Map<Square, Square>): Int {

    var newSquare = square

    return if (iterations < 3) {
        repeat(iterations) { val chunkSize = if (newSquare.size % 2 == 0) 2 else 3; newSquare = newSquare.chunk(chunkSize).map { it.enhance(rules) }.join() }
        newSquare.getOn()
    } else {
        repeat(2) { val chunkSize = if (newSquare.size % 2 == 0) 2 else 3; newSquare = newSquare.chunk(chunkSize).map { it.enhance(rules) }.join() }
        newSquare.chunk(2).map { it.enhance(rules) }.map { iterate(it, iterations - 3, rules) }.sum()
    }
}

private fun List<Square>.join(): Square {

    var squares = this.toList()
    val smallSize = (this.maxBy { it.size }?.size ?: 0)
    val largeSize = (smallSize * sqrt(this.size.toDouble())).roundToInt()
    val tempSquare = MutableList(largeSize) {
        MutableList(largeSize) {
            false
        }
    }

    for (r in 0 until largeSize step smallSize) {
        for (c in 0 until largeSize step smallSize) {
            for (row in 0 until smallSize) {
                for (column in 0 until smallSize) {
                    tempSquare[r+row][c+column] = squares[0].get(row, column)
                }
            }
            squares = squares.drop(1)
        }
    }

    return Square(tempSquare)
}

private fun parseInput(input: List<String>): Map<Square, Square> {

    val map = mutableMapOf<Square, Square>()

    input.forEach { p ->
        val (left, right, _) = p.split(" => ")
        val rightSquare = right.toSquare()
        left.toSquare().variants().forEach {
            map[it] = rightSquare
        }
    }

    return map
}

private fun String.toSquare(): Square {

    return Square(this.split("/").map { row -> row.map { column -> column == '#' } })
}

private fun readFile(pathname: String): List<String>? {

    return try {
        File(pathname /* aoc2017/dayXX/input.txt */).readLines()
    } catch (e: FileNotFoundException) {
        null
    }
}