package day16

import java.io.File
import java.io.FileNotFoundException

fun main(args: Array<String>) {

    val input = readFile("aoc2017/day16/input.txt")

    if (input == null) {
        println("Input file not found")
    } else {
        val output = dance(input.split(','))
        println(output)
    }
}

private fun dance(moves: List<String>): String {

    var order = "abcdefghijklmnop"

    moves.forEach {

        when (it[0]) {
            's' -> order = spin(it.drop(1).toInt(), order)
            'x' -> { val (pos1, pos2) = it.drop(1).split('/').map { i -> i.toInt() }; order = exchange(pos1, pos2, order) }
            'p' -> { val (p1, p2) = it.drop(1).toCharArray().filter { c -> c != '/' }; order = partner(p1, p2, order) }
        }
    }

    return order
}

private fun spin(size: Int, programs: String): String {

    return programs.takeLast(size).plus(programs.take(programs.length-size))
}

private fun exchange(pos1: Int, pos2: Int, programs: String): String {

    val min: Int; val max : Int
    if (pos1 > pos2) { max = pos1; min = pos2 } else { max = pos2; min = pos1 }

    return programs.take(min).plus(programs[max]).plus(programs.substring(min+1, max)).plus(programs[min]).plus(programs.substring(max+1))
}

private fun partner(p1: Char, p2: Char, programs: String): String {

    val pos1 = programs.indexOf(p1)
    val pos2 = programs.indexOf(p2)

    return exchange(pos1, pos2, programs)
}

private fun readFile(pathname: String): String? {

    return try {
        File(pathname /* aoc2017/dayXX/input.txt */).readText()
    } catch (e: FileNotFoundException) {
        null
    }
}