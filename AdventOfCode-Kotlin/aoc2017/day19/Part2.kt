package day19

import day19.Direction.*

import java.io.File
import java.io.FileNotFoundException

fun main(args: Array<String>) {

    val input = readFile("aoc2017/day19/input.txt")

    if (input == null) {
        println("Input file not found")
    } else {

        val output = traverse(parseGrid(input))
        println(output)
    }
}

private fun traverse(grid: List<List<Char>>): Int {

    val pos = Point(grid[0].indexOf('|'), 0)
    var direction = DOWN
    var steps = 1

    move@ while (true) {

        when (direction) {
            UP    -> if (pos.y - 1 >= 0 && pos.x < grid[pos.y-1].size && grid[pos.y-1][pos.x] != ' ') pos.move(direction) else { direction = checkNeighbour(grid, pos, direction) ?: break@move; pos.move(direction) }
            DOWN  -> if (pos.y + 1 < grid.size && pos.x < grid[pos.y+1].size && grid[pos.y+1][pos.x] != ' ') pos.move(direction) else { direction = checkNeighbour(grid, pos, direction) ?: break@move; pos.move(direction) }
            LEFT  -> if (pos.x - 1 >= 0 && grid[pos.y][pos.x-1] != ' ') pos.move(direction) else { direction = checkNeighbour(grid, pos, direction) ?: break@move; pos.move(direction) }
            RIGHT -> if (pos.x + 1 < grid[pos.y].size && grid[pos.y][pos.x+1] != ' ') pos.move(direction) else { direction = checkNeighbour(grid, pos, direction) ?: break@move; pos.move(direction) }
        }

        steps++
    }

    return steps
}

private fun checkNeighbour(grid: List<List<Char>>, pos: Point, direction: Direction): Direction? {

    return if ((direction == LEFT || direction == RIGHT) && pos.y - 1 >= 0 && pos.x < grid[pos.y-1].size && grid[pos.y-1][pos.x] != ' ') UP
    else if ((direction == LEFT || direction == RIGHT) && pos.y + 1 < grid.size && pos.x < grid[pos.y+1].size && grid[pos.y+1][pos.x] != ' ') DOWN
    else if ((direction == UP || direction == DOWN) && pos.x - 1 >= 0 && grid[pos.y][pos.x-1] != ' ') LEFT
    else if ((direction == UP || direction == DOWN) && pos.x + 1 < grid[pos.y].size && grid[pos.y][pos.x+1] != ' ') RIGHT
    else null
}

private fun parseGrid(input: List<String>): List<List<Char>> = input.map { it.toList() }

private fun readFile(pathname: String): List<String>? {

    return try {
        File(pathname /* aoc2017/dayXX/input.txt */).readLines()
    } catch (e: FileNotFoundException) {
        null
    }
}