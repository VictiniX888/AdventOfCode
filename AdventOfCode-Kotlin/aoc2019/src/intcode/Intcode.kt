package intcode

class Intcode(commands: List<Int>) {

    private val program = commands.toMutableList()
    private var pointer = 0

    fun run(): List<Int> {

        while (pointer >= 0) {
            when (program[pointer]) {
                1  -> add()
                2  -> multiply()
                99 -> exit()
                else -> unknownOpcode(program[pointer])
            }
        }

        return program
    }

    private fun add() {

        program[program[pointer + 3]] = program[program[pointer + 1]] + program[program[pointer + 2]]
        pointer += 4
    }

    private fun multiply() {

        program[program[pointer + 3]] = program[program[pointer + 1]] * program[program[pointer + 2]]
        pointer += 4
    }

    private fun exit() {

        pointer = -1
    }

    private fun unknownOpcode(opcode: Int) {

        println("Unknown Opcode $opcode encountered. Program terminated")
        exit()
    }
}