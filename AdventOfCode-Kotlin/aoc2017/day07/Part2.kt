package day07

import java.io.File
import java.io.FileNotFoundException

fun main(args: Array<String>) {

    val input = readFile("aoc2017/day07/input.txt")

    if (input == null) {
        println("Input file not found")
    } else {
        val programs = input.map { it.split(" (",  ") -> ", ", ").toProgram() }
        val root = programs[0].findRoot(programs)
        val output = root.reconstructTree(programs).wrongWeight().second
        println(output)
    }
}

private fun Program.wrongWeight(): Pair<Int, Int> {

    val childrenWeights = this.children.map { val childrenWeight = it.wrongWeight(); if (childrenWeight.second != 0) {return@wrongWeight childrenWeight} else childrenWeight.first }
    val max = childrenWeights.max()
    val min = childrenWeights.min()

    if (max != null && min != null && max - min != 0) {
        val error = max - min
        val isUniqueMax = childrenWeights.filter { it == max }.count() == 1
        return Pair(-1, (if (isUniqueMax) this.children[childrenWeights.indexOf(max)].weight - error else this.children[childrenWeights.indexOf(min)].weight + error))
    }

    return Pair(childrenWeights.sum() + this.weight, 0)
}

private fun Program.totalWeight(): Int = this.children.sumBy { it.totalWeight() } + this.weight

private fun Program.reconstructTree(programs: List<Program>): Program {

    this.children = programs.filter { this.children.contains(Program(it.name)) }.map { it.reconstructTree(programs) }

    return this
}

private fun Program.findRoot(programs: List<Program>): Program {

    val root = programs.firstOrNull { it.children.contains(Program(this.name)) }

    return root?.findRoot(programs) ?: this
}

private fun String.toProgram(): Program {

    return Program(this)
}

private fun List<String>.toProgram(): Program {

    return when {
        this.size == 2 -> Program(this[0], this[1].dropLast(1).toInt())
        this.size > 2  -> Program(this[0], this[1].toInt(), this.subList(2, this.size).map { it.toProgram() })
        else           -> Program("null program")
    }
}

private fun readFile(pathname: String): List<String>? {

    return try {
        File(pathname /* aoc2017/dayXX/input.txt */).readLines()
    } catch (e: FileNotFoundException) {
        null
    }
}