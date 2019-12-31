package day02

import intcode.Intcode
import java.io.File

fun main() {

    val input = File("aoc2019/src/day02/input.txt")
            .readText()
            .split(",")
            .map(String::toInt)

    val nounVerbPair = findNounVerb(input, 19690720, 99, 99)
    if (nounVerbPair != null)  {
        val (noun, verb) = nounVerbPair
        val answer = 100 * noun + verb
        println(answer)
    } else {
        println("Noun-verb pair not found")
    }

}

typealias NounVerb = Pair<Int, Int>

private fun findNounVerb(input: List<Int>, output: Int, nounLimit: Int, verbLimit: Int): NounVerb? {

    val mutableInput = input.toMutableList()

    for (noun in 0..nounLimit) {
        mutableInput[1] = noun

        for (verb in 0..verbLimit) {
            mutableInput[2] = verb
            val completedProgram = runIntcodeComputer(mutableInput)
            return if (completedProgram[0] == output) Pair(noun, verb) else continue
        }
    }

    return null
}

private fun runIntcodeComputer(input: List<Int>): List<Int> = Intcode(input).run()
