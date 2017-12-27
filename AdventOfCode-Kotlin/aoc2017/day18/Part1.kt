package day18

import java.io.File
import java.io.FileNotFoundException

fun main(args: Array<String>) {

    val input = readFile("aoc2017/day18/input.txt")

    if (input == null) {
        println("Input file not found")
    } else {
        val output = recovered(input.map { it.split(" ") })
        println(output)
    }
}

private fun recovered(instructions: List<List<String>>): Long {

    val registers = mutableMapOf<String, Long>()
    var lastSound = 0L
    var pos = 0L

    run@ while (pos >= 0 && pos < instructions.size) {

        val it = instructions[pos.toInt()]

        when (it[0]) {
            "snd" -> { lastSound = it[1].toLongOrNull() ?: registers.getOrDefault(it[1], 0); pos++ }
            "set" -> { registers.put(it[1], it[2].toLongOrNull() ?: registers.getOrDefault(it[2], 0)); pos++ }
            "add" -> { registers.put(it[1], registers.getOrDefault(it[1], 0) + (it[2].toLongOrNull() ?: registers.getOrDefault(it[2], 0))); pos++ }
            "mul" -> { registers.put(it[1], registers.getOrDefault(it[1], 0) * (it[2].toLongOrNull() ?: registers.getOrDefault(it[2], 0))); pos++ }
            "mod" -> { registers.put(it[1], registers.getOrDefault(it[1], 0) % (it[2].toLongOrNull() ?: registers.getOrDefault(it[2], 0))); pos++ }
            "rcv" -> { if (it[1].toLongOrNull() ?: registers.getOrDefault(it[1], 0) != 0L) break@run else pos++ }
            "jgz" -> { if (it[1].toLongOrNull() ?: registers.getOrDefault(it[1], 0) > 0) pos += it[2].toLongOrNull() ?: registers.getOrDefault(it[2], 0) else pos++ }
        }
    }

    return lastSound
}

private fun readFile(pathname: String): List<String>? {

    return try {
        File(pathname /* aoc2017/dayXX/input.txt */).readLines()
    } catch (e: FileNotFoundException) {
        null
    }
}