package day18

import java.io.File
import java.io.FileNotFoundException

fun main(args: Array<String>) {

    val input = readFile("aoc2017/day18/input.txt")

    if (input == null) {
        println("Input file not found")
    } else {
        val output = coop(input.map { it.split(" ") })
        println(output)
    }
}

private fun coop(instructions: List<List<String>>): Int {

    var register0 = mutableMapOf(Pair("p", 0L))
    var register1 = mutableMapOf(Pair("p", 1L))
    var queue0 = listOf<Long>()
    var queue1 = listOf<Long>()
    var pos0 = 0L
    var pos1 = 0L

    var sends = 0

    while (register0.isNotEmpty() && register1.isNotEmpty()) {

        val queueLength = queue0.size

        val program1 = run(instructions, register1.toMutableMap(), queue1.toMutableList(), pos1, 1)
        register1 = program1.first
        queue0 += program1.second.first.toList()
        pos1 = program1.third

        sends += queue0.size - queueLength

        val program0 = run(instructions, register0.toMutableMap(), queue0.toMutableList(), pos0, 0)
        register0 = program0.first
        queue1 = program0.second.first.toList()
        queue0 = program0.second.second.toList()
        pos0 = program0.third
    }

    return sends
}
//                                                                                                                                                                                          queue send      queue receive
private fun run(instructions: List<List<String>>, registers: MutableMap<String, Long>, queue: MutableList<Long>, position: Long, program: Int): Triple<MutableMap<String, Long>, Pair<MutableList<Long>, MutableList<Long>>, Long> {

    var pos = position
    val send = mutableListOf<Long>()

    loop@ while (pos >= 0 && pos < instructions.size) {

        val it = instructions[pos.toInt()]

        when (it[0]) {
            "snd" -> { pos++; send.add(it[1].toLongOrNull() ?: registers.getOrDefault(it[1], 0)); if (program == 0) return Triple(registers, Pair(send, queue), pos) }
            "set" -> { registers.put(it[1], it[2].toLongOrNull() ?: registers.getOrDefault(it[2], 0)); pos++ }
            "add" -> { registers.put(it[1], registers.getOrDefault(it[1], 0) + (it[2].toLongOrNull() ?: registers.getOrDefault(it[2], 0))); pos++ }
            "mul" -> { registers.put(it[1], registers.getOrDefault(it[1], 0) * (it[2].toLongOrNull() ?: registers.getOrDefault(it[2], 0))); pos++ }
            "mod" -> { registers.put(it[1], registers.getOrDefault(it[1], 0) % (it[2].toLongOrNull() ?: registers.getOrDefault(it[2], 0))); pos++ }
            "rcv" -> { if (queue.isNotEmpty()) { registers.put(it[1], queue[0]); queue.removeAt(0); pos++ } else if (program == 1) return Triple(registers, Pair(send, queue), pos) else break@loop }
            "jgz" -> { if (it[1].toLongOrNull() ?: registers.getOrDefault(it[1], 0) > 0) pos += it[2].toLongOrNull() ?: registers.getOrDefault(it[2], 0) else pos++ }
        }
    }

    return Triple(mutableMapOf(), Pair(mutableListOf(), mutableListOf()), 0)
}

private fun readFile(pathname: String): List<String>? {

    return try {
        File(pathname /* aoc2017/dayXX/input.txt */).readLines()
    } catch (e: FileNotFoundException) {
        null
    }
}