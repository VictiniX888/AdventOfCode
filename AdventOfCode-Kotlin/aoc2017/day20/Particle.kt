package day20

data class Particle(val id: Int, var posX: Int, var posY: Int, var posZ: Int, var velX: Int, var velY: Int, var velZ: Int, val accX: Int, val accY: Int, val accZ: Int) {

    fun move() {

        velX += accX
        velY += accY
        velZ += accZ
        posX += velX
        posY += velY
        posZ += velZ
    }
}