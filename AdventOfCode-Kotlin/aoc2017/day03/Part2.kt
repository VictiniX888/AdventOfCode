package day03

import java.io.File
import java.io.FileNotFoundException
import kotlin.math.*

fun main(args: Array<String>) {

    val input = readFile("aoc2017/day03/input.txt")

    if (input == null) {
        println("Input file not found")
    } else {
        val inputInt = input.toInt()
        val output = sumGrid(inputInt)
        println(output)
    }
}

private fun sumGrid(n: Int): Int {      // this is ugly but gets the job done so I'm not complaining

    val maxGrid = ceil(sqrt(n.toDouble())).toInt()

    val grid = MutableList(maxGrid, { MutableList(maxGrid, {0})})

    var x = maxGrid / 2
    var y = maxGrid / 2
    var squareSize = 2
    grid[x][y] = 1

    x++

    while (x < maxGrid && y < maxGrid) {
        for (i in y until y + squareSize) {

            val sum = grid[x+1][i] + grid[x+1][i+1] + grid[x][i+1] + grid[x-1][i+1] + grid[x-1][i] + grid[x-1][i-1] + grid[x][i-1] + grid[x+1][i-1]
            if (sum > n) {
                return sum
            }
            grid[x][i] = sum
        }

        y += squareSize - 1

        for (i in x downTo x - squareSize) {

            val sum = grid[i+1][y] + grid[i+1][y+1] + grid[i][y+1] + grid[i-1][y+1] + grid[i-1][y] + grid[i-1][y-1] + grid[i][y-1] + grid[i+1][y-1]
            if (sum > n) {
                return sum
            }
            grid[i][y] = sum
        }

        x -= squareSize

        for (i in y downTo y - squareSize) {

            val sum = grid[x+1][i] + grid[x+1][i+1] + grid[x][i+1] + grid[x-1][i+1] + grid[x-1][i] + grid[x-1][i-1] + grid[x][i-1] + grid[x+1][i-1]
            if (sum > n) {
                return sum
            }
            grid[x][i] = sum
        }

        y -= squareSize

        for (i in x .. x + squareSize) {

            val sum = grid[i+1][y] + grid[i+1][y+1] + grid[i][y+1] + grid[i-1][y+1] + grid[i-1][y] + grid[i-1][y-1] + grid[i][y-1] + grid[i+1][y-1]
            if (sum > n) {
                return sum
            }
            grid[i][y] = sum
        }

        x += squareSize + 1
        squareSize += 2
    }

    return 0
}

private fun readFile(pathname: String): String? {

    return try {
        File(pathname /* aoc2017/dayXX/input.txt */).readText()
    } catch (e: FileNotFoundException) {
        null
    }
}