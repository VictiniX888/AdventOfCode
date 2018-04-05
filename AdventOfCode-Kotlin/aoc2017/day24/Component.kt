package day24

class Component(val port1: Int, val port2: Int) {

    val strength = port1 + port2

    override fun equals(other: Any?): Boolean = other is Component && other.port1 == port1 && other.port2 == port2

    override fun hashCode(): Int {
        var result = port1
        result = 31 * result + port2
        result = 31 * result + strength
        return result
    }

    fun canConnect(port: Int): Boolean = port == port1 || port == port2

    fun flip(): Component = Component(port2, port1)

}

class Bridge(val components: List<Component>) {

    val strength = components.sumBy { it.strength }
    val endPort = components.last().port2

    fun addComponent(component: Component): Bridge = Bridge(components + component)
}