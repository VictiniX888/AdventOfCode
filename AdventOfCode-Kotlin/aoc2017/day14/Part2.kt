package day14

import java.io.File
import java.io.FileNotFoundException

fun main(args: Array<String>) {

    val input = readFile("aoc2017/day14/input.txt")

    if (input == null) {
        println("Input file not found")
    } else {

        val output = getRegions(getGrid(input))
        println(output)
    }
}

private fun getRegions(grid: List<List<Boolean>>): Int {

    val mutableGrid = grid.map { it.toMutableList() }.toMutableList()
    var regions = 0

    grid.forEachIndexed { indexRow, listRow ->
        listRow.forEachIndexed { indexCol, _ ->
            if (mutableGrid[indexRow][indexCol]) {
                regions++
                freeAdjacent(indexRow, indexCol, mutableGrid)
            }
        }
    }

    return regions
}

private fun freeAdjacent(indexRow: Int, indexCol: Int, grid: MutableList<MutableList<Boolean>>) {

    grid[indexRow][indexCol] = false

    if (indexRow > 0 && grid[indexRow-1][indexCol])                         { freeAdjacent(indexRow-1, indexCol, grid) }
    if (indexRow < grid.size - 1 && grid[indexRow+1][indexCol])             { freeAdjacent(indexRow+1, indexCol, grid) }
    if (indexCol > 0 && grid[indexRow][indexCol-1])                         { freeAdjacent(indexRow, indexCol-1, grid) }
    if (indexCol < grid[indexRow].size - 1 && grid[indexRow][indexCol+1])   { freeAdjacent(indexRow, indexCol+1, grid) }
}

private fun getGrid(key: String): List<List<Boolean>> {

    return (0 .. 127).map { i -> getBinaryHash(getHash(getDense(knot("$key-$i".map { it.toByte() } + listOf<Byte>(17, 31, 73, 47, 23))))).map { it == '1' } }
}

private fun getBinaryHash(hash: String): String {

    return hash.fold("", { acc, c -> acc.plus(Integer.parseInt(c.toString(), 16).toString(2).padStart(4, '0')) })
}

private fun getHash(dense: List<Int>): String {

    return dense.fold("", { acc, i -> acc.plus(i.toString(16).padStart(2, '0')) })
}

private fun getDense(sparse: List<Int>): List<Int> {

    return sparse.chunked(16, { it.reduce { acc, i -> acc.xor(i) } })
}

private fun knot(lengths: List<Byte>): List<Int> {

    val circle = (0..255).toMutableList()
    var skip = 0
    var pos = 0

    (0..63).forEach {
        lengths.forEach { length ->

            val reversed: List<Int>

            if (pos + length > circle.size) {
                reversed = circle.toMutableList().subList(pos, circle.size)
                reversed.addAll(circle.toList().subList(0, (pos + length) % circle.size))
                reversed.reverse()
            } else {
                reversed = circle.toList().subList(pos, pos + length).reversed()
            }

            (pos..pos + length - 1).forEach { circle[it % circle.size] = reversed[it - pos] }
            pos = (pos + length + skip) % circle.size
            skip++
        }
    }

    return circle
}

private fun readFile(pathname: String): String? {

    return try {
        File(pathname /* aoc2017/dayXX/input.txt */).readText()
    } catch (e: FileNotFoundException) {
        null
    }
}