package day12

import java.io.File
import java.io.FileNotFoundException

fun main(args: Array<String>) {

    val input = readFile("aoc2017/day12/input.txt")

    if (input == null) {
        println("Input file not found")
    } else {
        val output = getGroup(0, input.map { it.split(" <-> ", ", ").map { it.toInt() } }.toMap()).count()
        println(output)
    }
}

private fun getGroup(groupNumber: Int, communications: Map<Int, List<Int>>, group: MutableSet<Int> = mutableSetOf()): MutableSet<Int> {

    group.add(groupNumber)

    communications
            .getValue(groupNumber)
            .filter { !group.contains(it) }
            .forEach { group.addAll(getGroup(it, communications, group)) }

    return group
}

private fun List<List<Int>>.toMap(): Map<Int, List<Int>> = this.fold(mutableMapOf(), { acc, list -> acc.put(list[0], list.toList().subList(1, list.size)); acc })

private fun readFile(pathname: String): List<String>? {

    return try {
        File(pathname /* aoc2017/dayXX/input.txt */).readLines()
    } catch (e: FileNotFoundException) {
        null
    }
}