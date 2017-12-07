package day07

data class Program(val name: String, var weight: Int = -1, var children: List<Program> = listOf())
