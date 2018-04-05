package day23


fun main(args: Array<String>) {

    val output = (109900 .. 126900 step 17).count { !isPrime(it) }

    println(output)
}

private fun isPrime(n: Int): Boolean {

    for (i in 2 until n) {
        if (n % i == 0) return false
    }

    return true
}