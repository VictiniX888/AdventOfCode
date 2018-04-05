package day25

fun main(args: Array<String>) {

    val machine = TuringMachine()
    repeat(12173597) {
        machine.step()
    }
    val output = machine.getChecksum()
    println(output)
}

class TuringMachine(var state: Int = 0, var cursor: Int = 0, val tape: MutableList<Int> = mutableListOf(0)) {

    fun step() {

        when (state) {
            0 ->
                    when (tape[cursor]) {
                        0 -> {
                            tape[cursor] = 1
                            move(Direction.RIGHT)
                            state = 1
                        }
                        1 -> {
                            tape[cursor] = 0
                            move(Direction.LEFT)
                            state = 2
                        }
                    }
            1 ->
                    when (tape[cursor]) {
                        0 -> {
                            tape[cursor] = 1
                            move(Direction.LEFT)
                            state = 0
                        }
                        1 -> {
                            tape[cursor] = 1
                            move(Direction.RIGHT)
                            state = 3
                        }
                    }
            2 ->
                    when (tape[cursor]) {
                        0 -> {
                            tape[cursor] = 1
                            move(Direction.RIGHT)
                            state = 0
                        }
                        1 -> {
                            tape[cursor] = 0
                            move(Direction.LEFT)
                            state = 4
                        }
                    }
            3 ->
                    when (tape[cursor]) {
                        0 -> {
                            tape[cursor] = 1
                            move(Direction.RIGHT)
                            state = 0
                        }
                        1 -> {
                            tape[cursor] = 0
                            move(Direction.RIGHT)
                            state = 1
                        }
                    }
            4 ->
                    when (tape[cursor]) {
                        0 -> {
                            tape[cursor] = 1
                            move(Direction.LEFT)
                            state = 5
                        }
                        1 -> {
                            tape[cursor] = 1
                            move(Direction.LEFT)
                            state = 2
                        }
                    }
            5 ->
                    when (tape[cursor]) {
                        0 -> {
                            tape[cursor] = 1
                            move(Direction.RIGHT)
                            state = 3
                        }
                        1 -> {
                            tape[cursor] = 1
                            move(Direction.RIGHT)
                            state = 0
                        }
                    }
        }
    }

    fun getChecksum() = tape.sum()

    fun move(direction: Direction) {

        when (direction) {
            Direction.LEFT ->  {
                cursor--
                if (cursor < 0) {
                    tape.add(0, 0)
                    cursor++
                }
            }
            Direction.RIGHT -> {
                cursor++
                if (cursor >= tape.size) {
                    tape.add(0)
                }
            }
        }
    }
}

enum class Direction {
    LEFT, RIGHT
}