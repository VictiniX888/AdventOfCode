package day23

import java.io.File
import java.io.FileNotFoundException

fun main(args: Array<String>) {

    val input = readFile("aoc2017/day23/input.txt")

    if (input == null) {
        println("Input file not found")
    } else {
        val output = run(input.map { it.split(" ") })
        println(output)
    }
}

private fun run(instructions: List<List<String>>): Int {

    val registers = MutableList(8, { 0L })
    var pos = 0
    var count = 0

    while (pos >= 0 && pos < instructions.size) {

        when (instructions[pos][0]) {

            "set" -> registers[regToInt(instructions[pos][1])] = instructions[pos][2].toLongOrNull() ?: registers[regToInt(instructions[pos][2])]
            "sub" -> registers[regToInt(instructions[pos][1])] -= instructions[pos][2].toLongOrNull() ?: registers[regToInt(instructions[pos][2])]
            "mul" -> { registers[regToInt(instructions[pos][1])] *= instructions[pos][2].toLongOrNull() ?: registers[regToInt(instructions[pos][2])]; count++ }
            "jnz" -> if (instructions[pos][1].toLongOrNull() ?: registers[regToInt(instructions[pos][1])] != 0L) pos += (instructions[pos][2].toLongOrNull() ?: registers[regToInt(instructions[pos][2])]).toInt() - 1
        }

        pos++
    }

    return count
}

private fun regToInt(register: String) = register[0].toInt() - 97

private fun readFile(pathname: String): List<String>? {

    return try {
        File(pathname /* aoc2017/dayXX/input.txt */).readLines()
    } catch (e: FileNotFoundException) {
        null
    }
}