package day10

import java.io.File
import java.io.FileNotFoundException

fun main(args: Array<String>) {

    val input = readFile("aoc2017/day10/input.txt")

    if (input == null) {
        println("Input file not found")
    } else {

        val inputBytes = input.map { it.toByte() } + listOf<Byte>(17, 31, 73, 47, 23)
        val output = getHash(getDense(knot(inputBytes)))
        println(output)
    }
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