package day07

import java.io.File
import java.io.FileNotFoundException

fun main(args: Array<String>) {

    val input = readFile("aoc2017/day07/input.txt")

    if (input == null) {
        println("Input file not found")
    } else {
        val programs = input.map { it.split(" (",  ") -> ", ", ").toProgram() }
        val output = programs[0].findRoot(programs)
        println(output)
    }
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