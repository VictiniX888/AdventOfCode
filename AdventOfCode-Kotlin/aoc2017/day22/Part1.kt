package day22

import java.io.File
import java.io.FileNotFoundException

fun main(args: Array<String>) {

    val input = readFile("aoc2017/day22/input.txt")

    if (input == null) {
        println("Input file not found")
    } else {
        println(infectionCount(parseGrid(input)))
    }
}

private fun parseGrid(grid: List<String>): SquareGrid {

    val gridInit: List<State> = grid.flatMap { r -> r.map { c -> if (c == '.') State.CLEAN else State.INFECTED } }
    return SquareGrid(gridInit, grid.size)
}

private fun SquareGrid.burst() {

    val pos = index(carrier.posX, carrier.posY)

    when (this.grid[pos]) {
        State.CLEAN -> {
            carrier.turn(Direction.LEFT)
            this.grid[pos] = State.INFECTED
            infections++
        }
        State.INFECTED -> {
            carrier.turn(Direction.RIGHT)
            this.grid[pos] = State.CLEAN
        }
        else -> { }
    }

    carrier.forward()

    if (carrier.posX < 0 || carrier.posX >= size || carrier.posY < 0 || carrier.posY >= size) {

        enlarge()
    }
}

private fun infectionCount(grid: SquareGrid): Int {

    repeat(10000) {
        grid.burst()
    }

    return grid.infections
}

private fun readFile(pathname: String): List<String>? {

    return try {
        File(pathname /* aoc2017/dayXX/input.txt */).readLines()
    } catch (e: FileNotFoundException) {
        null
    }
}