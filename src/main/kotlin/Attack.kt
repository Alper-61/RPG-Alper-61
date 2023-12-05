open class Character(val name: String, var hp: Int, val maxHp: Int, val actions: List<String>) {
    fun isAlive(): Boolean = hp > 0
    fun takeDamage(damage: Int) {
        hp = (hp - damage)
        println("$name erleidet $damage Schaden. Verbleibende HP: $hp")
    }
    fun heal(amount: Int) {
        hp = (hp + amount)
        println("$name heilt sich um $amount. HP: $hp")
    }

}